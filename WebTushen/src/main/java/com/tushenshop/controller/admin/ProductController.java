package com.tushenshop.controller.admin;

import com.tushenshop.exception.ProductException;
import com.tushenshop.model.Product;
import com.tushenshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/show")
    public ModelAndView showProductList(Model model) {
        List<Product> productList = productService.listAll();
        model.addAttribute("productList", productList);
        return new ModelAndView("admin/product/show");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            productService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Product deleted successfully");
        } catch (ProductException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return new ModelAndView("redirect:/admin/product/show");
    }

}