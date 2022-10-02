package com.localizaai.LocalizaAPI.services.cepidentification;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CEPIdentificationService {
    public String findCEP(String document) {
        Matcher matcher = Pattern.compile("\\d{5}-\\d{3}").matcher(document);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
