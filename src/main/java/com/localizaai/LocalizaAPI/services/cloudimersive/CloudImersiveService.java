package com.localizaai.LocalizaAPI.services.cloudimersive;

import com.cloudmersive.client.ImageOcrApi;
import com.cloudmersive.client.model.ImageToTextResponse;
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
    public String callApi(File file){
        ImageOcrApi apiInstance = new ImageOcrApi();
        try {
            ImageToTextResponse result = apiInstance.imageOcrPost(file,"Normal","POR","Auto" );
            return (result.getTextResult());
        } catch (Exception e) {
            System.err.println("Exception when calling ScanApi#scanFile");
            e.printStackTrace();
            return "Algo deu errado";
        }
    }

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

    public String mocked(){
        return "PREZADO(A) CLIENTE\n" +
                "PELA VIDA DAS MULHERES, PECA AJUDA. DENUNCIE. LIGUE 180 OU 190.\n" +
                "DADOS DA UNIDADE CONSUMIDORA\n" +
                "JOAO IGOR DOS SANTOS PEREIRA\n" +
                "CPF: 022.968.502-19\n" +
                "AV JOAO BATISTA MORATO DO CANTO, 1400 TP 1 AP 408\n" +
                "CLASSIFICACAO: Convencional B1 Residencial - Bifasico 220 / 127 V\n" +
                "FUNDACAO CASA P\n" +
                "13031-390 CAMPINAS - SP\n" +
                "ATENDIMENTO\n" +
                "PN\n" +
                "SEU CODIGO\n" +
                "CONTA MES\n" +
                "VENCIMENTO\n" +
                "TOTAL A PAGAR\n" +
                "0800 010 1010\n" +
                "716526435\n" +
                "INSTALACAO\n" +
                "SET/2022\n" +
                "18/10/2022\n" +
                "www.cpfl.com.br\n" +
                "4002802926\n" +
                "DISCRIMINACAO DA OPERACAO - RESERVADO AO FISCO\n" +
                "Cod.\n" +
                "Descricao da Operacao\n" +
                "Mes\n" +
                "Quant.\n" +
                "Unid.\n" +
                "Tarifa com\n" +
                "Valor Total\n" +
                "Base Calculo\n" +
                "Aliq.\n" +
                "ICMS\n" +
                "Base Calculo\n" +
                "PIS\n" +
                "COFINS\n" +
                "Bandeiras\n" +
                "115\n" +
                "N' 916850663703\n" +
                "Ref.\n" +
                "Faturada\n" +
                "Med.\n" +
                "Tributos R$ da Operacao\n" +
                "RS\n" +
                "ICMS R$\n" +
                "ICMS\n" +
                "PIS/COFINS\n" +
                "0,74%\n" +
                "3,41%\n" +
                "Tarifarias\n" +
                "(Dias)\n" +
                "0605 Consumo Uso Sistema [KWh]-TUSD\n" +
                "SET/22\n" +
                "- KWh\n" +
                "Verde\n" +
                "0601 Consumo - TE\n" +
                "SET/22\n" +
                "KWh\n" +
                "21 Dias\n" +
                "Total Distribuidora\n" +
                "Verde\n" +
                "09 Dias";
    }
}
