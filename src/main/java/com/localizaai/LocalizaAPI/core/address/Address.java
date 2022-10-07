package com.localizaai.LocalizaAPI.core.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private Location location;
}
