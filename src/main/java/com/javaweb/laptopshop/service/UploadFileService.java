package com.javaweb.laptopshop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UploadFileService {
    public String saveImage(MultipartFile avatarFile, String imageType);
    public void updateImage(MultipartFile avatarFile, String oldImageName, String imageType);
}
