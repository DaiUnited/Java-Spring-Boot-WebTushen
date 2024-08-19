package com.tushenshop.controller.admin;

import com.tushenshop.exception.UserException;
import com.tushenshop.model.User;
import com.tushenshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Hiển thị danh sách người dùng
    @GetMapping("/show")
    public ModelAndView showUserList(Model model) {
        List<User> userList = userService.listAll();
        model.addAttribute("userList", userList);
        return new ModelAndView("admin/user/show");
    }

    // Hiển thị trang tạo người dùng mới
    @GetMapping("/create")
    public ModelAndView createUser(Model model) {
        model.addAttribute("user", new User());
        return new ModelAndView("admin/user/create");
    }

    // Xử lý việc lưu người dùng mới
    @PostMapping("/save")
    public ModelAndView saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return new ModelAndView("redirect:/admin/user/show");
    }


    // Hiển thị trang cập nhật người dùng
    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            User user = userService.get(id);
            model.addAttribute("user", user);
            return new ModelAndView("admin/user/update");
        } catch (UserException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return new ModelAndView("redirect:/admin/user/show");
        }
    }

    // Xử lý việc cập nhật người dùng
    @PostMapping("/update")
    public ModelAndView updateUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        try {
            userService.updateUser(user);
            redirectAttributes.addFlashAttribute("message", "User updated successfully");
        } catch (UserException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return new ModelAndView("redirect:/admin/user/show");
    }

    // Xóa người dùng
    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            userService.delete(id);
            redirectAttributes.addFlashAttribute("message", "The user has been deleted successfully");
        } catch (UserException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return new ModelAndView("redirect:/admin/user/show");
    }
}
