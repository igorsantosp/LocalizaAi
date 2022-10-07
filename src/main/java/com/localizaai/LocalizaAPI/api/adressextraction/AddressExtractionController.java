package com.localizaai.LocalizaAPI.api.adressextraction;

import com.cloudmersive.client.invoker.ApiException;
import com.localizaai.LocalizaAPI.api.addressimage.AddressImageResponseBody;
import com.localizaai.LocalizaAPI.core.addressextraction.AddressExtractionService;
import com.localizaai.LocalizaAPI.core.addressextraction.AddressExtraction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address-extraction")
public class AddressExtractionController {
    private final AddressExtractionService addressExtractionService;

    @PostMapping
    public ResponseEntity<AddressExtractionResponseBody> extractAddress(
        @RequestBody AddressExtractionRequestBody body) throws ApiException {
        log.info("AddressExtractionController: m=extractAddress, body={}", body);
        return ResponseEntity.ok(
            new AddressExtractionResponseBody(addressExtractionService.extract(body.getImageId())));
    }
}
