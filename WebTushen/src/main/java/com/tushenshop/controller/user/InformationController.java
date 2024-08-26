package com.tushenshop.controller.user;

import com.tushenshop.exception.UserException;
import com.tushenshop.model.User;
import com.tushenshop.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/user")
public class InformationController {

    @Autowired
    private UserService userService;

    @GetMapping("/inform")
    public String showUserInformation(Model model, HttpSession session) throws UserException {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            User user = userService.get(loggedInUser.getUserId());
            model.addAttribute("user", user);
            session.setAttribute("loggedInUser", user);
        }
        return "user/inform";

    }

    @PostMapping("/update")
    public ModelAndView updateUserInformation(@ModelAttribute("user") User updatedUser, HttpSession session, RedirectAttributes redirectAttributes) throws UserException {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null && updatedUser.getUserId() == loggedInUser.getUserId()) {
            try {
                userService.updateUser(updatedUser);
                session.setAttribute("loggedInUser", updatedUser);
                redirectAttributes.addFlashAttribute("message", "User updated successfully");
            } catch (UserException e) {
                redirectAttributes.addFlashAttribute("message", e.getMessage());
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "Invalid user session or update data.");
        }

        return new ModelAndView("redirect:/user/inform");
    }



    // Handle password change
    @PostMapping("/change-password")
    public ModelAndView changePassword(@RequestParam("currentPassword") String currentPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 HttpSession session, RedirectAttributes redirectAttrs) throws UserException {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return new ModelAndView("redirect:/login");
        }

        // Check if the current password is correct
        if (!currentPassword.equals(loggedInUser.getPassword())) {
            redirectAttrs.addFlashAttribute("error", "Current password is incorrect.");
            return new ModelAndView("redirect:/user/inform");
        }

        // Update to the new password
        loggedInUser.setPassword(newPassword);
        userService.updateUser(loggedInUser);

        redirectAttrs.addFlashAttribute("message", "Password changed successfully!");
        return new ModelAndView("redirect:/user/inform");
    }
}

