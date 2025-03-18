package com.javaweb.laptopshop.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.javaweb.laptopshop.domain.User;
import com.javaweb.laptopshop.domain.dto.RegisterDTO;

public interface UserService {
    public List<User> getAllUsers();
    public List<User> findAllUsersByEmail(String email);
    public User handleSaveUser(User user);
    public User getUserById(Long id);
    public User getUserByEmail(String email);
    public void deleteUserById(Long id);
    public User handleSaveUser(User user, MultipartFile avatarFile);
    public Long countUser();
    public void registerUserHandle(RegisterDTO registerDTO);
    public boolean checkEmailExist(String email);
}
