package com.javaweb.laptopshop.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.laptopshop.service.UploadFileService;

import jakarta.servlet.ServletContext;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    @Value("${avatar-image.path}")
    String avatarImagePath;

    @Value("${product-image.path}")
    String productImagePath;

    @Autowired
    ServletContext servletContext;

    @Override
    public String saveImage(MultipartFile imageFile, String imageType) {
        String imagePath = null;
        
        switch (imageType) {
            case "avatar":
                imagePath = avatarImagePath;
                break;
            case "product":
                imagePath = productImagePath;
                break;
        }

        if (!imageFile.isEmpty()) {
            String originalFilename = imageFile.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFilename = UUID.randomUUID().toString() + extension;

            String realPath = servletContext.getRealPath(imagePath);

            File uploadDir = new File(realPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            File uploadFile = new File(realPath, newFilename);
            try {
                imageFile.transferTo(uploadFile);
                return newFilename;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return "default-avatar.png";
        }
        return null;
    }

}
