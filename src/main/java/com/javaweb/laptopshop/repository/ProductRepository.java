package com.javaweb.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.laptopshop.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    long count();
    List<Product> findAll();
    Product save(Product product);
    Product getById(Long id);
    void deleteById(Long id);
}
