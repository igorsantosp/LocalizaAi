package com.localizaai.LocalizaAPI.controllers;

import com.localizaai.LocalizaAPI.services.CloudImersiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    CloudImersiveService imageService;
    @PostMapping("/upload")
    public String receiveImage(@RequestParam(value = "file") MultipartFile file, @RequestParam("extension") String extension) throws IOException {
        InputStream initialStream = file.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);


        File image = new File("/teste"+"."+extension);


        try (OutputStream outStream = new FileOutputStream(image)) {
            outStream.write(buffer);
        }
        boolean created=image.createNewFile();
        return imageService.callApi(image);

    }
}
