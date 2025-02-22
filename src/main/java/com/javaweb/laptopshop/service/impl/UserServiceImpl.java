package com.javaweb.laptopshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.laptopshop.domain.User;
import com.javaweb.laptopshop.repository.RoleRepository;
import com.javaweb.laptopshop.repository.UserRepository;
import com.javaweb.laptopshop.service.RoleService;
import com.javaweb.laptopshop.service.UploadFileService;
import com.javaweb.laptopshop.service.UserService;

import jakarta.servlet.ServletContext;

@Service
public class UserServiceImpl implements UserService{

    @Autowired UserRepository userRepository;
    @Autowired RoleRepository roleRepository;
    @Autowired ServletContext servletContext;
    @Autowired UploadFileService uploadFileService;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired RoleService roleService;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllUsersByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User handleSaveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User handleSaveUser(User user, MultipartFile avatarFile) {
        String avatarImageName = uploadFileService.saveImage(avatarFile, "avatar");
        user.setAvatar(avatarImageName);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleService.findByName(user.getRole().getName()));
        return userRepository.save(user);
    }

    @Override
    public Long countUser() {
        return userRepository.count();
    }
}
