package com.javaweb.laptopshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.laptopshop.domain.Cart;
import com.javaweb.laptopshop.domain.CartDetail;
import com.javaweb.laptopshop.domain.Product;
import com.javaweb.laptopshop.domain.User;
import com.javaweb.laptopshop.repository.CartDetailRepository;
import com.javaweb.laptopshop.repository.CartRepository;
import com.javaweb.laptopshop.repository.ProductRepository;
import com.javaweb.laptopshop.repository.UserRepository;
import com.javaweb.laptopshop.service.ProductService;
import com.javaweb.laptopshop.service.UploadFileService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired private UserRepository userRepository;
    @Autowired private CartRepository cartRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private CartDetailRepository cartDetailRepository;
    @Autowired private UploadFileService uploadFileService;

    @Override
    public long countProduct() {
        return productRepository.count();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product, MultipartFile imageFile) {
        String productImageName = uploadFileService.saveImage(imageFile, "product");
        product.setImage(productImageName);
        return productRepository.save(product);
    }

    @Override
    public Product getById(long id) {
        return productRepository.getById(id);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update(Product product, MultipartFile imageFile) {
        Product oldProduct = productRepository.getById(product.getId());
        try {
            if (imageFile != null && !imageFile.isEmpty()) {
                String oldImageName = oldProduct.getImage();
                if (!oldImageName.equals("default-product.png")) {
                    uploadFileService.updateImage(imageFile, oldImageName, "product");
                } else {
                    oldProduct.setImage(uploadFileService.saveImage(imageFile, "product"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setSold(product.getSold());
        oldProduct.setQuantity(product.getQuantity());
        oldProduct.setDetailDesc(product.getDetailDesc());
        oldProduct.setShortDesc(product.getShortDesc());
        oldProduct.setFactory(product.getFactory());
        oldProduct.setTarget(product.getTarget());

        productRepository.save(oldProduct);
    }

    @Override
    public void addProductToCart(long productId, String email) {
        User user = userRepository.getOneByEmail(email);
        if (user != null) {
            Product product = productRepository.getById(productId);
            if (product != null) {
                Cart cart = cartRepository.findByUser(user);
                if (cart == null) {
                    cart = new Cart();
                    cart.setUser(user);
                    cart.setSum(0);
                    cartRepository.save(cart);
                }
                
                CartDetail cartDetail = cartDetailRepository.findByCartAndProduct(cart, product);
                if (cartDetail == null) {
                    cart.setSum(cart.getSum() + 1);
                    cartRepository.save(cart);
                    cartDetail = new CartDetail();
                    cartDetail.setCart(cart);
                    cartDetail.setProduct(product);
                    cartDetail.setPrice(product.getPrice());
                    cartDetail.setQuantity(1);
                } else {
                    cartDetail.setQuantity(cartDetail.getQuantity() + 1);
                }
                
                cartDetailRepository.save(cartDetail);
            }
        }
    }
}
