package com.javaweb.laptopshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.laptopshop.domain.Role;
import com.javaweb.laptopshop.domain.User;
import com.javaweb.laptopshop.domain.dto.RegisterDTO;
import com.javaweb.laptopshop.mapper.UserMapper;
import com.javaweb.laptopshop.repository.RoleRepository;
import com.javaweb.laptopshop.repository.UserRepository;
import com.javaweb.laptopshop.service.RoleService;
import com.javaweb.laptopshop.service.UploadFileService;
import com.javaweb.laptopshop.service.UserService;

import jakarta.servlet.ServletContext;

@Service
public class UserServiceImpl implements UserService {

    @Autowired UserRepository userRepository;
    @Autowired RoleRepository roleRepository;
    @Autowired ServletContext servletContext;
    @Autowired UploadFileService uploadFileService;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired RoleService roleService;
    @Autowired UserMapper userMapper;

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
        if (user.getAvatar() == null) {
            user.setAvatar("default-avatar.png");
        } else {
            String avatarImageName = uploadFileService.saveImage(avatarFile, "avatar");
            user.setAvatar(avatarImageName);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleService.findByName(user.getRole().getName()));
        return userRepository.save(user);
    }

    @Override
    public Long countUser() {
        return userRepository.count();
    }

    @Override
    public void registerUserHandle(RegisterDTO registerDTO) {
        User user = userMapper.toUser(registerDTO);
        Role userRole = roleRepository.findByName("USER");
        user.setRole(userRole);
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        System.out.println(userRole);
        System.out.println(user);
        userRepository.save(user);
    }

    @Override
    public boolean checkEmailExist(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getOneByEmail(email);
    }
}
