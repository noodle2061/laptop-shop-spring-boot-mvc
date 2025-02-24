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
    public void updateImage(MultipartFile avatarFile, String oldImageName, String imageType) {
        if (avatarFile!=null && !avatarFile.isEmpty()) {
            String imagePath = getImagePath(imageType);
            String realPath = servletContext.getRealPath(imagePath);
            checkExistDir(realPath);

            File oldFile = new File(realPath, oldImageName);
            oldFile.delete();

            File uploadFile = new File(realPath, oldImageName);
            handleSaveFile(avatarFile, uploadFile);
            // return oldImageName;
        } 
    }

    @Override
    public String saveImage(MultipartFile imageFile, String imageType) {
        if (!imageFile.isEmpty()) {
            String imagePath = getImagePath(imageType);
            String originalFilename = imageFile.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = UUID.randomUUID().toString() + extension;

            String realPath = servletContext.getRealPath(imagePath);
            checkExistDir(realPath);

            File uploadFile = new File(realPath, newFileName);
            handleSaveFile(imageFile, uploadFile);
            return newFileName;
        } else {
            return "default-"+imageType+".png";
        }
    }

    public void handleSaveFile(MultipartFile imageFile, File uploadFile) {
        try {
            imageFile.transferTo(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getImagePath(String imageType) {
        switch (imageType) {
            case "avatar":
                return avatarImagePath;
            case "product":
                return productImagePath;
            default:
                return null;
        }
    }

    public void checkExistDir(String realPath) {
        File uploadDir = new File(realPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    
}
