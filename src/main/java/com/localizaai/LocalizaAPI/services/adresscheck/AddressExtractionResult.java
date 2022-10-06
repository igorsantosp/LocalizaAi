package com.localizaai.LocalizaAPI.services.adresscheck;

import com.localizaai.LocalizaAPI.model.Address;
import com.localizaai.LocalizaAPI.model.FullAddress;
import lombok.Data;

@Data
public class AddressExtractionResult {
    private final FullAddress address;
    private final boolean correiosMatch;
}
