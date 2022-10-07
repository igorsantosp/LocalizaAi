package com.localizaai.LocalizaAPI.core.addressimage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AddressImage {
    @Id
    private String id;

    private String filename;
}
