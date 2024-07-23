package com.o2.travel_agency.flightfare.application;


import com.o2.travel_agency.flightfare.domain.service.FlightFareService;

public class UpdateFlightFareByIdUseCase {
    private final FlightFareService flightFareService;

    public UpdateFlightFareByIdUseCase (FlightFareService flightFareService) {
        this.flightFareService = flightFareService;
    }

    public Boolean execute(String updateColumns, Integer id) {
        return flightFareService.updateFlightfareById(updateColumns, id);
    }
    
}
