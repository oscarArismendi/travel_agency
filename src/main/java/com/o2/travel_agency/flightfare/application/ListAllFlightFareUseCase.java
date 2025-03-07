package com.o2.travel_agency.flightfare.application;

import java.util.List;


import com.o2.travel_agency.flightfare.domain.entity.FlightFare;
import com.o2.travel_agency.flightfare.domain.service.FlightFareService;

public class ListAllFlightFareUseCase {
      private final FlightFareService flightFareService;

    public ListAllFlightFareUseCase(FlightFareService flightFareService) {
        this.flightFareService = flightFareService;
    }
    
    public  List<FlightFare> execute(){
        return flightFareService.listAllFlightFareUseCase();
    }
}

