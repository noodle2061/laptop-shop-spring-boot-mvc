package com.javaweb.laptopshop.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaweb.laptopshop.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class ItemController {

    @Autowired ProductService productService;
    
    @GetMapping("/product/{id}")
    public String getMethodName(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "client/product/detail";
    }

    @PostMapping("/add-product-to-cart/{id}")
    public String postMethodName(@PathVariable("id") long productId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            String email = (String) session.getAttribute("email");
            if (email != null) {
                // User đã đăng nhập
                // Thêm sản phẩm vào giỏ hàng
                productService.addProductToCart(productId, email);
            }
        }
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String getMethodName(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            String email = (String) session.getAttribute("email");
            if (email != null) {
                
            }
        }
        return "client/cart/show";
    }
    
}
