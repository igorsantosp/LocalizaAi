package com.localizaai.LocalizaAPI.core.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class TextAddress {
    private String textCep;
    private String textState;
    private String textCity;
    private String textNeighborhood;
    private String textStreet;

    public Address toAddress() {
        return Address.builder()
            .cep(textCep)
            .state(textState)
            .city(textCity)
            .neighborhood(textNeighborhood)
            .street(textStreet)
            .build();
    }
}
