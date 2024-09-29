package com.tushenshop.fitnesse;

import com.tushenshop.ShopApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.tushenshop.service.UserService;

public class SpringContext {

    private static ApplicationContext context;

    static {
        // Khởi tạo ngữ cảnh Spring (chỉ cần khởi tạo một lần)
        context = new AnnotationConfigApplicationContext(ShopApplication.class);
    }

    public static UserService getUserService() {
        return context.getBean(UserService.class);
    }
}
