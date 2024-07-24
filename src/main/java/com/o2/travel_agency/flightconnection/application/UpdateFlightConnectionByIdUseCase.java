package com.o2.travel_agency.flightconnection.application;

import com.o2.travel_agency.flightconnection.domain.service.FlightConectionService;

public class UpdateFlightConnectionByIdUseCase {
     private final FlightConectionService flightConectionService;

    public UpdateFlightConnectionByIdUseCase (FlightConectionService flightConectionService) {
        this.flightConectionService = flightConectionService;
    }

    public Boolean execute(String updateColumns, Integer id) {
        return flightConectionService.updateFlightConneciontById(updateColumns, id);
    }
}
