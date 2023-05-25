package com.qintess.spring.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/upload")
public class ImageUploadController {

    @Value("${upload.directory}") // Configurar o diretório de upload no arquivo application.properties
    private String uploadDirectory;

    @PostMapping
    public String uploadImage(@RequestBody MultipartFile image) throws IOException {
        String imageName = generateUniqueFileName(image.getOriginalFilename());
        String imagePath = uploadDirectory + File.separator + imageName;
        File destination = new File(imagePath);
        image.transferTo(destination);

        return imageName;
    }

    private String generateUniqueFileName(String originalFileName) {
        String uniqueName = UUID.randomUUID().toString();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        return uniqueName + fileExtension;
    }
}