package com.tushenshop.fitnesse;

import com.tushenshop.model.User;
import com.tushenshop.service.UserService;
import fit.ColumnFixture;
import org.mockito.Mockito;
import org.springframework.stereotype.Component;

@Component
public class LoginFixture extends ColumnFixture {

    public String username;
    public String password;

    private UserService userService;

    public LoginFixture() {
        // Sử dụng Mockito để tạo đối tượng mock UserService
        this.userService = Mockito.mock(UserService.class);

        // Thiết lập các tình huống trả về cho phương thức login của UserService
        Mockito.when(userService.login("admin", "admin123")).thenReturn(new User());
        Mockito.when(userService.login("dai", "dai155")).thenReturn(new User());
    }

    public boolean login() {
        User user = userService.login(username, password);
        return user != null; // Trả về true nếu đăng nhập thành công, false nếu thất bại
    }
}
