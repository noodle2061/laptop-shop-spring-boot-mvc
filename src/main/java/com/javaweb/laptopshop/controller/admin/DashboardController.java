package com.javaweb.laptopshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.javaweb.laptopshop.service.UserService;



@Controller
public class DashboardController {
    @Autowired UserService userService;
    
    @GetMapping("/admin")
    public String getMethodName(Model model) {
        model.addAttribute("countUsers", userService.countUser());
        return "admin/dashboard/show";
    }
    
}
