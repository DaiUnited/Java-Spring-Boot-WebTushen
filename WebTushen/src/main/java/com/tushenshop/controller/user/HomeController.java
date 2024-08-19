package com.tushenshop.controller.user;

import com.tushenshop.model.Product;
import com.tushenshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RequestMapping("/user")
@Controller(value = "homeControllerOfUser")
public class HomeController {
    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public ModelAndView showProductListHome(Model model) {
        List<Product> productList = productService.listAll();
        model.addAttribute("productList", productList);
        return new ModelAndView("user/home");
    }

    @RequestMapping(value = "/san-pham", method = RequestMethod.GET)
    public ModelAndView productPage()
    {
        ModelAndView mav = new ModelAndView("user/product");
        return  mav;
    }

    @RequestMapping(value = "/kham-pha", method = RequestMethod.GET)
    public ModelAndView aboutPage()
    {
        ModelAndView mav = new ModelAndView("user/about");
        return  mav;
    }

}
