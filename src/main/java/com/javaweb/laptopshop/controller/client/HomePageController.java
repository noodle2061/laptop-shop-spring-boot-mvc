package com.javaweb.laptopshop.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaweb.laptopshop.domain.dto.RegisterDTO;
import com.javaweb.laptopshop.mapper.UserMapper;
import com.javaweb.laptopshop.service.ProductService;
import com.javaweb.laptopshop.service.UserService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class HomePageController {

    @Autowired ProductService productService;
    @Autowired UserMapper userMapper;
    @Autowired UserService userService;
    
    @GetMapping("/")
    public String getMethodName(Model model) {
        model.addAttribute("products", productService.getAll());
        return "client/homepage/show";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "client/auth/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registerUser") @Valid RegisterDTO registerUser,
    BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("hello Error");
            return "client/auth/register";
        }
        System.out.println(registerUser);
        userService.registerUserHandle(registerUser);
        return "redirect:login";
    }

    @GetMapping("/deny")
    public String denyPage() {
        return "client/auth/deny";
    }
    
    @GetMapping("/product/{id}")
    public String getMethodName(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "client/product/detail";
    }
}
