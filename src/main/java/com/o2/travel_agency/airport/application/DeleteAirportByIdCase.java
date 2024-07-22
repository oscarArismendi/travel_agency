package com.o2.travel_agency.airport.application;

import com.o2.travel_agency.airport.domain.service.AirportService;

public class DeleteAirportByIdCase {
    private final AirportService airportService;

    public  DeleteAirportByIdCase(AirportService  airportService) {
        this.airportService = airportService;
    }

    public Boolean execute(Integer id) {
        return airportService.deleteAirportById(id);
    }
}
