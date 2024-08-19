package com.tushenshop.controller.admin;

import com.tushenshop.exception.CategoryException;
import com.tushenshop.model.Category;
import com.tushenshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Hiển thị danh sách các loại sản phẩm
    @GetMapping("/show")
    public ModelAndView showCategoryList(Model model) {
        List<Category> categoryList = categoryService.listAll();
        model.addAttribute("categoryList", categoryList);
        return new ModelAndView("admin/category/show");
    }

    // Hiển thị trang tạo loại sản phẩm mới
    @GetMapping("/create")
    public ModelAndView createCategory(Model model) {
        model.addAttribute("category", new Category());
        return new ModelAndView("admin/category/create");
    }

    // Xử lý việc lưu loại sản phẩm mới
    @PostMapping("/save")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return new ModelAndView("redirect:/admin/category/show");
    }

    // Hiển thị trang cập nhật loại sản phẩm
    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Category category = categoryService.get(id);
            model.addAttribute("category", category);
            return new ModelAndView("admin/category/update");
        } catch (CategoryException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return new ModelAndView("redirect:/admin/category/show");
        }
    }

    // Xử lý việc cập nhật loại sản phẩm
    @PostMapping("/update")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        try {
            categoryService.updateCategory(category);
            redirectAttributes.addFlashAttribute("message", "Category updated successfully");
        } catch (CategoryException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return new ModelAndView("redirect:/admin/category/show");
    }

    // Xóa loại sản phẩm
    @GetMapping("/delete/{id}")
    public ModelAndView deleteCategory(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            categoryService.delete(id);
            redirectAttributes.addFlashAttribute("message", "The category has been deleted successfully");
        } catch (CategoryException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return new ModelAndView("redirect:/admin/category/show");
    }
}
