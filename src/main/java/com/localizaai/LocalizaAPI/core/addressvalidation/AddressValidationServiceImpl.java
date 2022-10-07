package com.localizaai.LocalizaAPI.core.addressvalidation;

import com.cloudmersive.client.invoker.ApiException;
import com.localizaai.LocalizaAPI.core.address.ImageAddress;
import com.localizaai.LocalizaAPI.core.address.TextAddress;
import com.localizaai.LocalizaAPI.core.addressextraction.AddressExtraction;
import com.localizaai.LocalizaAPI.core.addressextraction.AddressExtractionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressValidationServiceImpl implements AddressValidationService {
    private final AddressExtractionService addressExtractionService;

    private final AddressValidationRepository addressValidationRepository;

    @Override
    public AddressValidation validate(String imageId, TextAddress textAddress) throws ApiException {
        log.info("AddressValidationServiceImpl: m=validate, imageId={}, textAddress={}", imageId, textAddress);
        AddressExtraction addressExtraction = addressExtractionService.extract(imageId);
        ImageAddress imageAddress = addressExtraction.getImageAddress();
        AddressValidation addressValidation = AddressValidation.builder()
            .id(UUID.randomUUID().toString())
            .imageAddress(imageAddress)
            .textAddress(textAddress)
            .match(Objects.equals(imageAddress.getImageCep(), textAddress.getTextCep()))
            .confidence(addressExtraction.getConfidence())
            .build();
        log.info("AddressValidationServiceImpl: m=validate, addressValidation={}", addressValidation);

        return addressValidationRepository.save(addressValidation);
    }
}
