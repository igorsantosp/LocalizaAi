package com.localizaai.LocalizaAPI.core.addressvalidation;

import com.localizaai.LocalizaAPI.core.address.Address;
import com.localizaai.LocalizaAPI.core.address.ImageAddress;
import com.localizaai.LocalizaAPI.core.address.TextAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressValidation {
    @Id
    private String id;
    @Embedded
    private ImageAddress imageAddress;
    @Embedded
    private TextAddress textAddress;
    private boolean match;
    private float confidence;
}
