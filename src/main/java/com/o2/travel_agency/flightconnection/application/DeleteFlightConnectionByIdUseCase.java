package com.o2.travel_agency.flightconnection.application;

import com.o2.travel_agency.flightconnection.domain.service.FlightConectionService;

public class DeleteFlightConnectionByIdUseCase {
    private final FlightConectionService flightConectionService;

    public  DeleteFlightConnectionByIdUseCase(FlightConectionService flightConectionService) {
        this.flightConectionService = flightConectionService;
    }

    public Boolean execute(Integer id) {
        return flightConectionService.deleteFlightConnectionById(id);
    }
}
