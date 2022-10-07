package com.localizaai.LocalizaAPI.core.addressextraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressExtractionRepository extends JpaRepository<AddressExtraction, String> {
}
