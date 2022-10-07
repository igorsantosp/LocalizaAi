package com.localizaai.LocalizaAPI.api.addressvalidation;

import com.cloudmersive.client.invoker.ApiException;
import com.localizaai.LocalizaAPI.core.addressextraction.AddressExtractionService;
import com.localizaai.LocalizaAPI.core.addressextraction.AddressExtraction;
import com.localizaai.LocalizaAPI.core.addressvalidation.AddressValidation;
import com.localizaai.LocalizaAPI.core.addressvalidation.AddressValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address-validation")
public class AddressValidationController {

    private final AddressValidationService addressValidationService;

    @PostMapping
    public ResponseEntity<AddressValidationResponseBody> validateAddress(
        @RequestBody AddressValidationRequestBody body) throws ApiException {
        log.info("AddressValidationController: m=validateAddress, body={}", body);
        return ResponseEntity.ok(
            new AddressValidationResponseBody(
                addressValidationService.validate(body.getImageId(), body.getAddress().toTextAddress())));
    }
}
