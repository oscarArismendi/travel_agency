package com.o2.travel_agency.airline.application;

import java.util.List;

import com.o2.travel_agency.airline.domain.entity.Airline;
import com.o2.travel_agency.airline.domain.service.AirlineService;

public class ListAllAirlinesUseCase {
    private final AirlineService airlineService;

    public ListAllAirlinesUseCase(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    public List<Airline> execute() {
        return airlineService.listAllAirlines();
    }
}
