package com.localizaai.LocalizaAPI.core.addressvalidation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressValidationRepository extends JpaRepository<AddressValidation, String> {

}
