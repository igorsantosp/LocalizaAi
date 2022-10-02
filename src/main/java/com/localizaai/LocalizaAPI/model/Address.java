package com.localizaai.LocalizaAPI.model;

import lombok.Data;

@Data
public class Address {
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
}
