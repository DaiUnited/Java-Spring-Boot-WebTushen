package com.tushenshop.controller;

import com.tushenshop.model.Category;
import com.tushenshop.model.Product;
import com.tushenshop.service.CategoryService;
import com.tushenshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/home")
    public ModelAndView showProductListHome(Model model) {
        List<Product> productList = productService.listAll();
        model.addAttribute("productList", productList);
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ModelAndView shopProductPage(Model model)
    {
        List<Product> productList = productService.listAll();
        model.addAttribute("productList", productList);
        List<Category> categoryList = categoryService.listAll();
        model.addAttribute("categoryList", categoryList);
        ModelAndView mav = new ModelAndView("shop");
        return  mav;
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView aboutPage()
    {
        ModelAndView mav = new ModelAndView("about");
        return  mav;
    }

}
