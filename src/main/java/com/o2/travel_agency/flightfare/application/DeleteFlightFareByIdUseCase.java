package com.o2.travel_agency.flightfare.application;

import com.o2.travel_agency.flightfare.domain.service.FlightfareService;

public class DeleteFlightFareByIdUseCase {
    private final FlightfareService flightFareService;

    public DeleteFlightFareByIdUseCase(FlightfareService flightFareService) {
        this.flightFareService = flightFareService;
    }

    public Boolean execute(Integer id) {
        return flightFareService.deleteFlightFareTypeById(id);
    }
}
