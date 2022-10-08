package com.localizaai.LocalizaAPI.clients.cloudimersive;

import com.cloudmersive.client.ImageOcrApi;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.model.ImageToTextResponse;
import com.localizaai.LocalizaAPI.core.addressimage.AddressImage;
import com.localizaai.LocalizaAPI.core.addressimage.AddressImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.*;

import java.io.File;

@Slf4j
@Service
public class CloudImersiveService {
    @Autowired
    private AddressImageRepository addressImageRepository;

    private ApiClient client;
    public CloudImersiveService() {
        ApiClient client = Configuration.getDefaultApiClient().setConnectTimeout(50000).setReadTimeout(50000);

        // Configure API key authorization: Apikey
        ApiKeyAuth Apikey = (ApiKeyAuth) client.getAuthentication("Apikey");
        Apikey.setApiKey("fc13986f-8aa6-4cda-a02d-a5d70c5d7bb8");

    }
    public ImageToTextResponse covertToText(String imageId) throws ApiException {
        AddressImage addressImage = addressImageRepository.findById(imageId).orElseThrow(RuntimeException::new);
        File image = new File(addressImage.getFilename());
        ImageOcrApi apiInstance = new ImageOcrApi();
        return apiInstance.imageOcrPost(image,"Normal","POR","Auto");
        /*ImageToTextResponse imageToTextResponse = new  ImageToTextResponse();
        imageToTextResponse.setTextResult(imageToText());
        imageToTextResponse.setMeanConfidenceLevel(0.95F);
        return imageToTextResponse;*/
    }

    private String imageToText() {
        return "Nota Fiscal / Conta Gas\n" +
            "SEU ZE DO TESTE\n" +
            "Para uso Comgas\n" +
            "R GIRASSOL 555\n" +
            "05433-001 SAO PAULO SP\n" +
            "-0703472960000492561 1432130CCLNORMA\n" +
            "Mes de Referencia\n" +
            "Vencimento\n" +
            "8160\n" +
            "JUL/2022\n" +
            "28.07.2022";
    }
}
