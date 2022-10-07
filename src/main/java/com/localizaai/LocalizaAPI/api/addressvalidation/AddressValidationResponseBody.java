package com.localizaai.LocalizaAPI.api.addressvalidation;

import com.localizaai.LocalizaAPI.core.address.Address;
import com.localizaai.LocalizaAPI.core.addressvalidation.AddressValidation;
import lombok.Value;

@Value
public class AddressValidationResponseBody {
    String id;
    Address imageAddress;
    Address textAddress;
    boolean match;
    float confidence;

    public AddressValidationResponseBody(AddressValidation addressValidation) {
        id = addressValidation.getId();
        imageAddress = addressValidation.getImageAddress().toAddress();
        textAddress = addressValidation.getTextAddress().toAddress();
        match = addressValidation.isMatch();
        confidence = addressValidation.getConfidence();
    }
}
