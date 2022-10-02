package com.localizaai.LocalizaAPI.services.cloudimersive;

import org.springframework.stereotype.Service;
import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.*;

import java.io.File;

@Service
public class CloudImersiveService {
    ApiClient client;
    public CloudImersiveService() {
        ApiClient client = Configuration.getDefaultApiClient().setConnectTimeout(50000).setReadTimeout(50000);

        // Configure API key authorization: Apikey
        ApiKeyAuth Apikey = (ApiKeyAuth) client.getAuthentication("Apikey");
        Apikey.setApiKey("fc13986f-8aa6-4cda-a02d-a5d70c5d7bb8");

    }
    /*public String callApi(File file){
        ImageOcrApi apiInstance = new ImageOcrApi();
        try {
            ImageToTextResponse result = apiInstance.imageOcrPost(file,"Normal","POR","Auto" );
            return (result.getTextResult());
        } catch (Exception e) {
            System.err.println("Exception when calling ScanApi#scanFile");
            e.printStackTrace();
            return "Algo deu errado";
        }
    }*/

    public String imageToText(File file) {
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
