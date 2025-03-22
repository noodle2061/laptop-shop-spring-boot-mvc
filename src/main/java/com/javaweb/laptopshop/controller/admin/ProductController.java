package com.javaweb.laptopshop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.laptopshop.domain.Product;
import com.javaweb.laptopshop.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/admin/product")
    public String getMethodName(Model model) {
        model.addAttribute("products", productService.getAll());
        return "admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String addProduct(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create-product";
    }

    @PostMapping("/admin/product/create")
    public String postMethodName(@ModelAttribute("newProduct") Product newProduct,
            @RequestParam("productImage") MultipartFile imageFile) {
        productService.save(newProduct, imageFile);
        return "redirect:admin/product";
    }

    @GetMapping("/admin/product/detail")
    public String productDetailPage(Model model, @RequestParam("id") int id) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "admin/product/product-detail";
    }

    @GetMapping("/admin/product/delete")
    public String deleteProductPage(@RequestParam("id") long id, Model model) {
        model.addAttribute("id", id);
        return "admin/product/delete-product";
    }

    @PostMapping("/admin/product/delete")
    public String deleteProduct(@RequestParam("id") long id) {
        productService.delete(id);
        return "redirect:admin/product";
    }

    @GetMapping("/admin/product/update")
    public String updateProductPage(@RequestParam("id") long id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "admin/product/update-product";
    }

    @PostMapping("/admin/product/update")
    public String updateProduct(@ModelAttribute("product") Product product,
            @RequestParam(value = "productImage", required = false) MultipartFile imageFile) {
        productService.update(product, imageFile);
        return "redirect:admin/product";
    }
}
