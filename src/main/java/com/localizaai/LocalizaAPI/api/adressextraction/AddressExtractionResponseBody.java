package com.localizaai.LocalizaAPI.api.adressextraction;

import com.localizaai.LocalizaAPI.core.address.Address;
import com.localizaai.LocalizaAPI.core.addressextraction.AddressExtraction;
import lombok.Value;

@Value
public class AddressExtractionResponseBody {
    String id;
    Address imageAddress;
    boolean correiosMatch;
    float confidence;

    public AddressExtractionResponseBody(AddressExtraction addressExtraction) {
        id = addressExtraction.getId();
        imageAddress = addressExtraction.getImageAddress().toAddress();
        correiosMatch = addressExtraction.isCorreiosMatch();
        confidence = addressExtraction.getConfidence();
    }
}
