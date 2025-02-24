package com.javaweb.laptopshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.laptopshop.domain.Product;
import com.javaweb.laptopshop.repository.ProductRepository;
import com.javaweb.laptopshop.service.ProductService;
import com.javaweb.laptopshop.service.UploadFileService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UploadFileService uploadFileService;

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
}
