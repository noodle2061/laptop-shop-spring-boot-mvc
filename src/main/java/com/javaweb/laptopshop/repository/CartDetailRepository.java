package com.javaweb.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.laptopshop.domain.Cart;
import com.javaweb.laptopshop.domain.CartDetail;
import com.javaweb.laptopshop.domain.Product;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    List<CartDetail> findByCart(Cart cart);
    void deleteByCart(Cart cart);
    void deleteByProduct(Product product);
    void deleteByCartAndProduct(Cart cart, Product product);
    CartDetail findByCartAndProduct(Cart cart, Product product);
    long countByCart(Cart cart);
    long countByProduct(Product product);
}
