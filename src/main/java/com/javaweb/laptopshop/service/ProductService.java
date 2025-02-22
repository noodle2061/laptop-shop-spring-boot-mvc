package com.javaweb.laptopshop.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.javaweb.laptopshop.domain.Product;

public interface ProductService {
    public long countProduct();
    public List<Product> getAll();
    public Product save(Product product, MultipartFile imageFile);
    public Product getById(long id);
    public void delete(long id);
    public void update(Product product);
}
