package com.localizaai.LocalizaAPI.core.addressextraction;

import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.model.ImageToTextResponse;
import com.localizaai.LocalizaAPI.clients.brasilapi.BrasilAPIAddressClient;
import com.localizaai.LocalizaAPI.clients.brasilapi.BrasilAPIAddress;
import com.localizaai.LocalizaAPI.core.cepidentification.CEPIdentificationService;
import com.localizaai.LocalizaAPI.clients.cloudimersive.CloudImersiveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressExtractionServiceImpl implements AddressExtractionService {
    private final CloudImersiveService cloudImersiveService;

    private final CEPIdentificationService cepIdentificationService;

    private final BrasilAPIAddressClient brasilAPIAddressClient;

    private final AddressExtractionRepository addressExtractionRepository;

    @Override
    public AddressExtraction extract(String imageId) throws ApiException {
        log.info("AddressExtractionServiceImpl: m=extract, imageId={}", imageId);
        ImageToTextResponse response = cloudImersiveService.covertToText(imageId);
        String cep = cepIdentificationService.findCEP(response.getTextResult());
        log.info("AddressExtractionServiceImpl: m=extract, cep={}", cep);
        BrasilAPIAddress brasilAPIAddress = brasilAPIAddressClient.findByCEP(cep);
        log.info("AddressExtractionServiceImpl: m=extract, brasilAPIAddress={}", brasilAPIAddress);

        UUID uuid = UUID.randomUUID();

        AddressExtraction addressExtraction
            = new AddressExtraction(uuid.toString(), brasilAPIAddress.toImageAddress(),
            true, response.getMeanConfidenceLevel());

        return addressExtractionRepository.save(addressExtraction);

    }
}
