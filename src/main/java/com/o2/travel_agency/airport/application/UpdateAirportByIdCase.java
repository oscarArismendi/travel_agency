package com.o2.travel_agency.airport.application;

import com.o2.travel_agency.airport.domain.service.AirportService;


public class UpdateAirportByIdCase {
    @SuppressWarnings("unused")
    private final AirportService airportService;

     public UpdateAirportByIdCase(AirportService airportService) {
        this.airportService = airportService;
    }

    public static Boolean execute(String updateColumns, int id) {
        return AirportService.updateAirportById(updateColumns, id);
    }
}
