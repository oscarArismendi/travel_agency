package com.o2.travel_agency.city.application;

import java.util.List;

import com.o2.travel_agency.city.domain.entity.City;
import com.o2.travel_agency.city.domain.service.CityService;

public class ListAllCitiesUseCase {
    private final CityService cityService;

    public ListAllCitiesUseCase(CityService cityService) {
        this.cityService = cityService;
    }
    
    public List<City> execute(){
        return cityService.listAllCities();
    }
}
