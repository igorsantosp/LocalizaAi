package com.localizaai.LocalizaAPI.core.addressimage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressImageService {
    private final AddressImageRepository addressImageRepository;

    public AddressImage saveAddressImage(MultipartFile file, String extension) throws IOException {
        InputStream initialStream = file.getInputStream();
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        UUID uuid = UUID.randomUUID();

        String filename = "src/main/resources/" + uuid + "." + extension;
        File image = new File(filename);

        try (OutputStream outStream = new FileOutputStream(image)) {
            outStream.write(buffer);
        }

        AddressImage addressImage = new AddressImage(uuid.toString(), filename);
        return addressImageRepository.save(addressImage);
    }
}
