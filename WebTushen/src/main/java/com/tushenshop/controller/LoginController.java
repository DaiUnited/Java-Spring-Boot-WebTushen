package com.tushenshop.controller;

import com.tushenshop.model.User;
import com.tushenshop.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";  // Chỉ hiển thị trang login.jsp
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {
        // Kiểm tra người dùng trong cơ sở dữ liệu
        User user = userService.login(username, password);

        if (user != null) {
            // Đăng nhập thành công, lưu thông tin người dùng vào session
            session.setAttribute("loggedInUser", user);

            // Kiểm tra vai trò người dùng
            if ("Admin".equals(user.getRole())) {
                // Nếu là admin, chuyển hướng tới trang quản trị
                return "redirect:/admin/home";
            } else {
                // Nếu không phải admin, chuyển hướng về trang chủ hoặc tiếp tục sử dụng trang thông thường
                return "redirect:/home";
            }
        } else {
            // Đăng nhập thất bại, trả về thông báo lỗi
            model.addAttribute("loginError", "Tên đăng nhập hoặc mật khẩu không đúng.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Xóa session hiện tại
        return "redirect:/home";  // Quay lại trang đăng nhập
    }
}
