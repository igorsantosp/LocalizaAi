package com.localizaai.LocalizaAPI.clients.brasilapi;

import com.localizaai.LocalizaAPI.core.address.Address;
import com.localizaai.LocalizaAPI.core.address.ImageAddress;
import lombok.Data;

@Data
public class BrasilAPIAddress {
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String service;
    private BrasilAPILocation location;

    public ImageAddress toImageAddress() {
        return ImageAddress.builder()
            .imageCep(cep)
            .imageState(state)
            .imageCity(city)
            .imageNeighborhood(neighborhood)
            .imageStreet(street)
            .location(location.toLocation())
            .build();
    }

    public Address toAddress() {
        return Address.builder()
            .cep(cep)
            .state(state)
            .city(city)
            .neighborhood(neighborhood)
            .street(street)
            .build();
    }
}
