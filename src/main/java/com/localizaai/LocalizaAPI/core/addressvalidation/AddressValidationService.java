package com.localizaai.LocalizaAPI.core.addressvalidation;

import com.cloudmersive.client.invoker.ApiException;
import com.localizaai.LocalizaAPI.core.address.Address;
import com.localizaai.LocalizaAPI.core.address.TextAddress;
import org.springframework.stereotype.Service;

@Service
public interface AddressValidationService {
    AddressValidation validate(String imageId, TextAddress textAddress) throws ApiException;
}
