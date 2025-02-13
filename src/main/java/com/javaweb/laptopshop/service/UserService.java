package com.javaweb.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaweb.laptopshop.domain.User;
import com.javaweb.laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public List<User> findAllUsersByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User handleSaveUser(User user) {
        return repository.save(user);
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}
