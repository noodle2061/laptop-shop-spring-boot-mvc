package com.javaweb.laptopshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.laptopshop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User hoidanit);
    List<User> findByEmail(String email);
    Optional<User> findById(Long id);
    void deleteById(Long id);
    long count();
} 
