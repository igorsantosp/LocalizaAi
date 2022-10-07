package com.localizaai.LocalizaAPI.core.addressextraction;

import com.cloudmersive.client.invoker.ApiException;

public interface AddressExtractionService {
    AddressExtraction extract(String id) throws ApiException;
}
