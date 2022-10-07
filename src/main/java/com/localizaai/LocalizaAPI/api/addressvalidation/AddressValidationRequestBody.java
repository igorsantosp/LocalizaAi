package com.localizaai.LocalizaAPI.api.addressvalidation;

import lombok.Data;

@Data
public class AddressValidationRequestBody {
    private String imageId;
    private AddressvalidationRequestAddress address;
}
