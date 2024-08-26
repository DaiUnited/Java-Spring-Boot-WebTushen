package com.tushenshop.service;

import com.tushenshop.exception.ProductException;
import com.tushenshop.exception.UserException;
import com.tushenshop.model.Cart;
import com.tushenshop.model.CartItem;
import com.tushenshop.model.Product;
import com.tushenshop.model.User;
import com.tushenshop.repository.CartRepository;
import com.tushenshop.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    // Lấy giỏ hàng của người dùng
    public Cart getCartForUser(User user) {
        return cartRepository.findByUserId(user.getUserId());
    }

    // Lấy tất cả các mục trong giỏ hàng
    public List<CartItem> getCartItems(Cart cart) {
        return cartItemRepository.findByCart(cart);
    }

    public void addProductToCart(User user, Product product, Integer quantity) throws ProductException, UserException {
        // Find or create the cart for the user
        Cart cart = cartRepository.findByUserId(user.getUserId());

        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
        }

        // Create a new CartItem
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        // Save the CartItem
        cartItemRepository.save(cartItem);
    }

    // Tính tổng số tiền của giỏ hàng
    public double getCartTotal(Cart cart) {
        return cartItemRepository.findByCart(cart)
                .stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    // Cập nhật số lượng sản phẩm trong giỏ hàng
    public void updateCartItemQuantity(Cart cart, int productId, int quantity) {
        CartItem cartItem = cartItemRepository.findByCartAndProductId(cart, productId);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        }
    }

    // Xóa sản phẩm khỏi giỏ hàng
    public void removeProductFromCart(Cart cart, int productId) {
        CartItem cartItem = cartItemRepository.findByCartAndProductId(cart, productId);
        if (cartItem != null) {
            cartItemRepository.delete(cartItem);
        }
    }
}
