package com.localizaai.LocalizaAPI.core.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ImageAddress {
    private String imageCep;
    private String imageState;
    private String imageCity;
    private String imageNeighborhood;
    private String imageStreet;
    @Embedded
    private Location location;

    public Address toAddress() {
        return Address.builder()
            .cep(imageCep)
            .state(imageState)
            .city(imageCity)
            .neighborhood(imageNeighborhood)
            .street(imageStreet)
            .location(location)
            .build();
    }
}
