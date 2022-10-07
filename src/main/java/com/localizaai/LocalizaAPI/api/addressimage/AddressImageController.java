package com.localizaai.LocalizaAPI.api.addressimage;

import com.localizaai.LocalizaAPI.core.addressimage.AddressImage;
import com.localizaai.LocalizaAPI.core.addressimage.AddressImageService;
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
@RequestMapping("/api/v1/address-image")
public class AddressImageController {

    private final AddressImageService addressImageService;

    @PostMapping
    public ResponseEntity<AddressImageResponseBody> createAddressImage(
        @RequestParam(value = "file") MultipartFile file,
        @RequestParam("extension") String extension) throws IOException {

        return ResponseEntity.ok(
            new AddressImageResponseBody(
                addressImageService.saveAddressImage(file, extension)));
    }
}
