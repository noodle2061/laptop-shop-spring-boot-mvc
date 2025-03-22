package com.javaweb.laptopshop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.laptopshop.domain.User;
import com.javaweb.laptopshop.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/admin/user")
    public String adminPage(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    @GetMapping("/admin/user/create")
    public String createUserPage(Model model) {
        // TODO: process POST request
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping("/admin/user/create") //
    public String createUser(@ModelAttribute("newUser") @Valid User user,
            BindingResult userBindingResult,
            @RequestParam("avatarFile") MultipartFile avatarFile) {
        if (userBindingResult.hasErrors()) {
            return "admin/user/create";
        }
        // Lưu thông tin user (bao gồm tên file avatar) vào DB
        userService.handleSaveUser(user, avatarFile);
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
    public String updateUser(Model model, 
    @ModelAttribute("user") @Valid User user, 
    @PathVariable("id") Long id) {
        User userUpdate = userService.getUserById(id);
        userUpdate.setFullname(user.getFullname());
        userUpdate.setPhone(user.getPhone());
        userUpdate.setAddress(user.getAddress());
        userService.handleSaveUser(userUpdate);
        return "redirect:admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String deleteUserPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("id", id);
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:admin/user";
    }

}