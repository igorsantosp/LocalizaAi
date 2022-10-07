package com.localizaai.LocalizaAPI.core.address;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Coordinates {
    private String longitude;
    private String latitude;
}
