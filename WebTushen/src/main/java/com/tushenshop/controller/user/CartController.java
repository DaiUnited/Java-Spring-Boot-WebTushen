package com.tushenshop.controller.user;

import com.tushenshop.exception.ProductException;
import com.tushenshop.exception.UserException;
import com.tushenshop.model.Cart;
import com.tushenshop.model.CartItem;
import com.tushenshop.model.Product;
import com.tushenshop.model.User;
import com.tushenshop.service.CartService;
import com.tushenshop.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/user")
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("productId") Integer productId, @RequestParam("quantity") Integer quantity, HttpSession session, RedirectAttributes redirectAttributes) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login";
        }

        try {
            Product product = productService.get(productId);
            cartService.addProductToCart(loggedInUser, product, quantity); // Default quantity is 1
            redirectAttributes.addFlashAttribute("message", "Product added to cart successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        } catch (ProductException | UserException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/detail?id=" + productId;
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login";
        }

        Cart cart = cartService.getCartForUser(loggedInUser);

        if (cart != null) {
            List<CartItem> cartItems = cartService.getCartItems(cart);
            double cartTotal = cartService.getCartTotal(cart);
            model.addAttribute("cartItems", cartItems);
            model.addAttribute("cartTotal", cartTotal);
        } else {
            model.addAttribute("cartItems", List.of());
            model.addAttribute("cartTotal", 0.0);
        }

        return "user/cart";
    }

    @PostMapping("/update-quantity")
    public String updateCartItem(@RequestParam("productId") Integer productId, HttpSession session, RedirectAttributes redirectAttributes) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login";
        }
        CartItem item = new CartItem();
        Cart cart = cartService.getCartForUser(loggedInUser);
        cartService.updateCartItemQuantity(cart, productId, item.getQuantity());
        return "redirect:/user/cart";
    }

    @PostMapping("/remove-from-cart")
    public String removeFromCart(@RequestParam("productId") Integer productId,
                                 HttpSession session, RedirectAttributes redirectAttributes) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login";
        }

        Cart cart = cartService.getCartForUser(loggedInUser);
        cartService.removeProductFromCart(cart, productId);

        return "redirect:/user/cart";
    }
}
