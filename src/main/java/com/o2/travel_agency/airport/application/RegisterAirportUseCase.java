package com.o2.travel_agency.airport.application;

import com.o2.travel_agency.airport.domain.entity.Airport;
import com.o2.travel_agency.airport.domain.service.AirportService;

public class RegisterAirportUseCase {
    private AirportService airportService;

    public RegisterAirportUseCase(AirportService airportService) {
        this.airportService = airportService;
    }

    public void registerAirport(int id, String name, String city, String country) {
        Airport airport = new Airport(id, name, city, country);
        airportService.saveAirport(airport);
    }
}

