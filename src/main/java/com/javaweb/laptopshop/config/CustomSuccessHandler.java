package com.javaweb.laptopshop.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.javaweb.laptopshop.domain.User;
import com.javaweb.laptopshop.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        
        // Mặc định nếu không có role ADMIN thì redirect về "/"
        String redirectUrl = "/";
        
        // Duyệt qua các role trong authentication để kiểm tra xem có ROLE_ADMIN không
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));
        
        if (isAdmin) {
            redirectUrl = "/admin";
        }

        HttpSession session = request.getSession();
        if (session != null) {
            // Lưu thông tin user vào session
            String email = authentication.getName();
            User user = userService.getUserByEmail(email);
            session.setAttribute("fullName", user.getFullname());
            session.setAttribute("avatar", user.getAvatar());
        }
        
        // Redirect đến URL phù hợp
        response.sendRedirect(redirectUrl);
    }
}
