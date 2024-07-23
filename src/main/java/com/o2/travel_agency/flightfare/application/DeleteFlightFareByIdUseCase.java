package com.o2.travel_agency.flightfare.application;


import com.o2.travel_agency.flightfare.domain.service.FlightFareService;

public class DeleteFlightFareByIdUseCase {
     private final FlightFareService flightFareService;

    public DeleteFlightFareByIdUseCase(FlightFareService flightFareService) {
        this.flightFareService = flightFareService;
    }

    public Boolean execute(Integer id) {
        return flightFareService.deleteFlightFareTypeById(id);
    }
}
