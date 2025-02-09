package com.javaweb.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaweb.laptopshop.domain.User;
import com.javaweb.laptopshop.service.UserService;

@Controller 
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<User> users = userService.findAllUsersByEmail("");
        System.out.println(users);
        model.addAttribute("eric", "test");
        return "hello";
    }

    @GetMapping("/admin/user")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    
    @PostMapping("/admin/user/create")
    public String createUserPage(Model model, @ModelAttribute("newUser") User hoidanit) {
        //TODO: process POST request
        userService.handleSaveUser(hoidanit);
        return "hello";
    }
    
}