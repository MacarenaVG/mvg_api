package com.example.mvg_api.repository;

import com.example.mvg_api.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByCommonName(String commonName);
}
