package com.localizaai.LocalizaAPI.model;

import com.localizaai.LocalizaAPI.services.adresscheck.AddressExtractionResult;
import lombok.Data;

@Data
public class FullAddress extends Address {
    Integer numero;
    public FullAddress(Address add, int numero){
        super.setCep(add.getCep());
        super.setCity(add.getCity());
        super.setNeighborhood(add.getNeighborhood());
        super.setState(add.getState());
        super.setStreet(add.getStreet());
        this.numero=numero;
    }
}
