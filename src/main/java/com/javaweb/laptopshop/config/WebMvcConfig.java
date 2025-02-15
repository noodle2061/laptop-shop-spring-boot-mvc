package com.javaweb.laptopshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration // Đánh dấu đây là class cấu hình Spring
@EnableWebMvc // Kích hoạt cấu hình Spring MVC mặc định
public class WebMvcConfig implements WebMvcConfigurer { // Class cấu hình WebMvc và implements interface
                                                        // WebMvcConfigurer để tùy chỉnh

    @Bean // Đánh dấu method này tạo ra một Bean quản lý bởi Spring Container
    public ViewResolver viewResolver() { // Định nghĩa Bean ViewResolver

        // Khởi tạo InternalResourceViewResolver - một implementation phổ biến của
        // ViewResolver
        final InternalResourceViewResolver bean = new InternalResourceViewResolver();

        // Thiết lập class View là JstlView để hỗ trợ JSTL trong JSP
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");

        // Trả về Bean ViewResolver đã cấu hình
        return bean;
    }

    @Override // Override method từ WebMvcConfigurer để cấu hình ViewResolvers
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // Đăng ký ViewResolver Bean đã tạo (viewResolver()) vào ViewResolverRegistry
        // để Spring MVC sử dụng nó.
        registry.viewResolver(viewResolver());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
    }
}