package com.localizaai.LocalizaAPI.services.adresscheck;

import com.localizaai.LocalizaAPI.model.Address;
import lombok.Data;

@Data
public class AddressExtractionResult {
    private final Address address;
    private final boolean correiosMatch;
}
