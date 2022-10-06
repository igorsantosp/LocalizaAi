package com.localizaai.LocalizaAPI.services.adresscheck;

import com.localizaai.LocalizaAPI.clients.AddressClient;
import com.localizaai.LocalizaAPI.model.Address;
import com.localizaai.LocalizaAPI.model.FullAddress;
import com.localizaai.LocalizaAPI.services.cepidentification.CEPIdentificationService;
import com.localizaai.LocalizaAPI.services.cloudimersive.CloudImersiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class AddressCheckServiceImpl implements AddressCheckService {
    private final CloudImersiveService cloudImersiveService;

    private final CEPIdentificationService cepIdentificationService;

    private final AddressClient addressClient;

    @Override
    public AddressExtractionResult extract(File image) {
        String imageOCR = cloudImersiveService.mocked();
        String cep = cepIdentificationService.findCEP(imageOCR);
        Integer number = cepIdentificationService.findNumber(imageOCR);
        Address address = addressClient.findByCEP(cep);
        return new AddressExtractionResult(new FullAddress(address, number), true);
    }

    @Override
    public AddressComparisonResult compare(Address address, File image) {
        return null;
    }
}
