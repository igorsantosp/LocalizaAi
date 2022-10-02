package com.localizaai.LocalizaAPI.controllers;

import com.localizaai.LocalizaAPI.services.adresscheck.AddressCheckService;
import com.localizaai.LocalizaAPI.services.adresscheck.AddressExtractionResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/address")
public class AddressController {
    private final AddressCheckService addressCheckService;

    @PostMapping("/extract")
    public ResponseEntity<AddressExtractionResult> receiveImage(@RequestParam(value = "file") MultipartFile file, @RequestParam("extension") String extension) throws IOException {
        InputStream initialStream = file.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);


        File image = new File("src/main/resources/targetFile"+"."+extension);


        try (OutputStream outStream = new FileOutputStream(image)) {
            outStream.write(buffer);
        }
        //image.createNewFile();
        return ResponseEntity.ok(addressCheckService.extract(image));

    }
}
