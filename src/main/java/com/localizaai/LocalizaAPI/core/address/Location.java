package com.localizaai.LocalizaAPI.core.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String type;
    @Embedded
    private Coordinates coordinates;
}
