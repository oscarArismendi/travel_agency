package com.o2.travel_agency.flightfare.application;

import java.util.List;


import com.o2.travel_agency.flightfare.domain.entity.FlightFare;
import com.o2.travel_agency.flightfare.domain.service.FlightfareService;

public class ListAllFlightFareUseCase {
      private final FlightfareService flightFareService;

    public ListAllFlightFareUseCase(FlightfareService flightFareService) {
        this.flightFareService = flightFareService;
    }
    
    public  List<FlightFare> execute(){
        return flightFareService.ListAllFlightFareUseCase();
    }
}

