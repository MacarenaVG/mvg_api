package com.example.mvg_api.service;


import com.example.mvg_api.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

import com.example.mvg_api.repository.CountryRepository;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public void fetchAndStoreCountries() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://restcountries.com/v3.1/all";
        // Realiza la solicitud GET a la API externa
        Object[] response = restTemplate.getForObject(url, Object[].class);

        if (response != null) {
            for (Object obj : response) {
                // Mapea la respuesta JSON a un objeto Java
                @SuppressWarnings("unchecked")
                Map<String, Object> countryMap = (Map<String, Object>) obj;

                // Extrae el nombre común
                Map<String, String> nameMap = (Map<String, String>) countryMap.get("name");
                String commonName = nameMap != null ? nameMap.get("common") : null;

                // Extrae la población
                Long population = ((Number) countryMap.get("population")).longValue();

                // Verifica si el país ya existe en la base de datos
                Country existingCountry = countryRepository.findByCommonName(commonName);

                if (existingCountry != null) {
                    // Actualiza el país existente
                    existingCountry.setPopulation(population);
                    countryRepository.save(existingCountry);
                } else {
                    // Crea una nueva instancia de la entidad Country y la guarda en la base de datos
                    Country country = new Country();
                    country.setCommonName(commonName);
                    country.setPopulation(population);
                    countryRepository.save(country);
                }
            }
        }
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
