package com.localizaai.LocalizaAPI.api.addressimage;

import com.localizaai.LocalizaAPI.core.addressimage.AddressImage;
import lombok.Value;

@Value
public class AddressImageResponseBody {
    String id;

    public AddressImageResponseBody(AddressImage addressImage) {
        id = addressImage.getId();
    }
}
