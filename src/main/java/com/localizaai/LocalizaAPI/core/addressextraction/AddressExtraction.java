package com.localizaai.LocalizaAPI.core.addressextraction;

import com.localizaai.LocalizaAPI.core.address.ImageAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AddressExtraction {
    @Id
    private String id;
    @Embedded
    private ImageAddress imageAddress;
    private boolean correiosMatch;
    private float confidence;
}
