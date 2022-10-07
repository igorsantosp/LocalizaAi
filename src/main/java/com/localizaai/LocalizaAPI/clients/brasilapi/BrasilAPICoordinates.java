package com.localizaai.LocalizaAPI.clients.brasilapi;

import com.localizaai.LocalizaAPI.core.address.Coordinates;
import lombok.Data;

@Data
public class BrasilAPICoordinates {
    private String longitude;
    private String latitude;

    public Coordinates toCoordinates() {
        return new Coordinates(longitude, latitude);
    }
}
