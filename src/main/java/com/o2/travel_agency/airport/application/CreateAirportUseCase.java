package com.o2.travel_agency.airport.application;

import com.o2.travel_agency.airport.domain.entity.Airport;
import com.o2.travel_agency.airport.domain.service.AirportService;


public class CreateAirportUseCase {
    private AirportService airportService;

    public CreateAirportUseCase(AirportService airportService) {
        this.airportService = airportService;
    }

   public void execute(Airport airport) {
        airportService.createAirport(airport);
    }
}

