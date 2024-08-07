package com.example.mvg_api.controller;


import com.example.mvg_api.model.Country;
import com.example.mvg_api.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/data")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/country")
    public void fetchAndStoreCountries() {
        countryService.fetchAndStoreCountries();
    }

    @GetMapping("/country")
    public List<Country> getCountries() {
        return countryService.getAllCountries();
    }
}