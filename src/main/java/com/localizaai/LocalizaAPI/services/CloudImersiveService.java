package com.localizaai.LocalizaAPI.services;

import com.cloudmersive.client.model.ImageToTextResponse;

import org.apache.catalina.webresources.FileResource;
import org.apache.catalina.webresources.FileResourceSet;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.*;
import com.cloudmersive.client.ImageOcrApi;
import javax.naming.spi.ResolveResult;
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
    public String callApi(File file){
        ImageOcrApi apiInstance = new ImageOcrApi();
        File inputFile = file; // File | Input file to perform the operation on.
        try {
            ImageToTextResponse result = apiInstance.imageOcrPost(file,"Normal","POR","Auto" );
            return (result.getTextResult());
        } catch (Exception e) {
            System.err.println("Exception when calling ScanApi#scanFile");
            e.printStackTrace();
            return "Algo deu errado";
        }
    }
}
