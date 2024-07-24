package com.o2.travel_agency.flightconnection.application;

import java.util.List;

import com.o2.travel_agency.flightconnection.domain.entity.FlightConnection;
import com.o2.travel_agency.flightconnection.domain.service.FlightConectionService;


public class ListAllFlightConnectionUseCase {
    private final FlightConectionService flightConectionService;

    public ListAllFlightConnectionUseCase(FlightConectionService flightConectionService) {
        this.flightConectionService = flightConectionService;
    }
    
    public  List<FlightConnection> execute(){
        return flightConectionService.listAllFlightConnection();
    }
    }

