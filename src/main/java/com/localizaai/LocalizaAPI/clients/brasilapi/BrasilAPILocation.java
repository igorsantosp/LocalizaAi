package com.localizaai.LocalizaAPI.clients.brasilapi;

import com.localizaai.LocalizaAPI.core.address.Location;
import lombok.Data;

@Data
public class BrasilAPILocation {
    private String type;
    private BrasilAPICoordinates coordinates;

    public Location toLocation() {
        return new Location(type, coordinates.toCoordinates());
    }
}
