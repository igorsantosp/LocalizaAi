package com.localizaai.LocalizaAPI.api.addressvalidation;

import com.localizaai.LocalizaAPI.core.address.TextAddress;
import lombok.Data;

@Data
public class AddressvalidationRequestAddress {
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;

    public TextAddress toTextAddress() {
        return TextAddress.builder()
            .textCep(cep)
            .textState(state)
            .textCity(city)
            .textNeighborhood(neighborhood)
            .textStreet(street)
            .build();
    }
}
