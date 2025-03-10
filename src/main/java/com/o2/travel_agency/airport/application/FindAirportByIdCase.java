package com.o2.travel_agency.airport.application;

import com.o2.travel_agency.airport.domain.entity.Airport;
import com.o2.travel_agency.airport.domain.service.AirportService;

public class FindAirportByIdCase {
    private final AirportService airportService;

    public FindAirportByIdCase(AirportService airportService) {
        this.airportService = airportService;
    }

    public Airport execute(Integer id) {
        return airportService.findAirportById(id);
    }

}
