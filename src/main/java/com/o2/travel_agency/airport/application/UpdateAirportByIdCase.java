package com.o2.travel_agency.airport.application;

import com.o2.travel_agency.airport.domain.service.AirportService;


public class UpdateAirportByIdCase {
    private final AirportService airportService;

     public UpdateAirportByIdCase(AirportService airportService) {
        this.airportService = airportService;
    }

    public Boolean execute(String updateColumns, int id) {
        return airportService.updateAirportById(updateColumns, id);
    }
}
