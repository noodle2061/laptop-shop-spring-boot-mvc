package com.javaweb.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        // List<User> users = userService.findAllUsersByEmail("");
        // System.out.println(users);
        // model.addAttribute("eric", "test");
        return "hello";
        // return "admin/dashboard/hello";
    }

    @GetMapping("/admin/user") 
    public String adminPage(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    @GetMapping("/admin/user/create")
    public String createUserPage(Model model) {
        //TODO: process POST request
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    
    @PostMapping("/admin/user/create")
    public String createUserPage(Model model, @ModelAttribute("newUser") User user) {
        //TODO: process POST request
        userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }
    

    @GetMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }

    @GetMapping("/admin/user/edit/{id}")
    public String updateUserPage(Model model, @PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/edit";
    }
    
    @PostMapping("/admin/user/edit/{id}")
    public String updateUser(Model model, @ModelAttribute("user") User user, @PathVariable("id") Long id) {
        //TODO: process POST request
        System.out.println(user);
        User userUpdate = userService.getUserById(id);
        userUpdate.setFullname(user.getFullname());
        userUpdate.setPhone(user.getPhone());
        userUpdate.setAddress(user.getAddress());
        userService.handleSaveUser(userUpdate);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String deleteUserPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("id", id);
        return "/admin/user/delete";
    }
    
    @PostMapping("/admin/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/user";
    }
    
}