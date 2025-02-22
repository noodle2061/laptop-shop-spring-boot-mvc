package com.javaweb.laptopshop.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.javaweb.laptopshop.domain.User;

public interface UserService {
    public List<User> getAllUsers();
    public List<User> findAllUsersByEmail(String email);
    public User handleSaveUser(User user);
    public User getUserById(Long id);
    public void deleteUserById(Long id);
    public User handleSaveUser(User user, MultipartFile avatarFile);
    public Long countUser();
}
