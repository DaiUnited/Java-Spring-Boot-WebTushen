package com.tushenshop.controller;

import com.tushenshop.exception.ProductException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "MainController")
public class HomeController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/home")
    public ModelAndView showProductListHome(Model model) {
        List<Product> productList = productService.listAll();
        model.addAttribute("productList", productList);
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ModelAndView shopProductPage(
            @RequestParam(value = "category", required = false) Integer categoryId,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "sort", required = false) String sort,
            Model model) {

        List<Product> productList;
        if (search != null && !search.isEmpty()) {
            // Tìm kiếm sản phẩm theo tên
            productList = productService.searchProducts(search, categoryId, sort);
        } else {
            // Lọc sản phẩm theo thể loại và sắp xếp nếu có
            productList = productService.findByCategoryIdAndSort(categoryId, sort);
        }

        model.addAttribute("productList", productList);

        List<Category> categoryList = categoryService.listAll();
        model.addAttribute("categoryList", categoryList);
        ModelAndView mav = new ModelAndView("shop");
        return mav;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView viewProductDetail(@RequestParam("id") int productId, Model model) {
        try {
            Product product = productService.get(productId);
            model.addAttribute("product", product);
            ModelAndView mav = new ModelAndView("detail");
            return mav;
        } catch (ProductException e) {
            return new ModelAndView("error").addObject("message", e.getMessage());
        }
    }


    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView aboutPage()
    {
        ModelAndView mav = new ModelAndView("about");
        return  mav;
    }

}
