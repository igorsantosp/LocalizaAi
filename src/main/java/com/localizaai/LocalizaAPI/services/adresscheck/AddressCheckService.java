package com.localizaai.LocalizaAPI.services.adresscheck;

import com.localizaai.LocalizaAPI.model.Address;

import java.io.File;

public interface AddressCheckService {
    AddressExtractionResult extract(File image);

    AddressComparisonResult compare(Address address, File image);
}
