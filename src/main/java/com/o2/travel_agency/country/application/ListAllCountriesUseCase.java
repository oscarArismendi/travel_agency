package com.o2.travel_agency.country.application;

import java.util.List;

import com.o2.travel_agency.country.domain.entity.Country;
import com.o2.travel_agency.country.domain.service.CountryService;

public class ListAllCountriesUseCase {
    private final CountryService countryService;

    public ListAllCountriesUseCase(CountryService countryService) {
        this.countryService = countryService;
    }

    public List<Country> execute(){
        return countryService.listAllCountries();
    }
}
