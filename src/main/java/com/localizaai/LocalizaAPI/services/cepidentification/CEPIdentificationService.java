package com.localizaai.LocalizaAPI.services.cepidentification;

import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CEPIdentificationService {
    public String findCEP(String document) {
        Matcher matcher = Pattern.compile("\\d{5}-\\d{3} ").matcher(document);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    public Integer findNumber(String document) {
        Matcher matcher = Pattern.compile("ap(.*\\d)|apto(.*\\d)|apartamento(.*\\d)|numero(.*\\d)|nº(.*\\d)").matcher(document.toLowerCase());
        if (matcher.find()) {
            return Integer.parseInt(matcher.group().replaceAll("[^0-9]", "").trim());
        }
        return null;
    }
}
