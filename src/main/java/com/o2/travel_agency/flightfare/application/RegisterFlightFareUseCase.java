package com.o2.travel_agency.flightfare.application;


import com.o2.travel_agency.flightfare.domain.entity.FlightFare;
import com.o2.travel_agency.flightfare.domain.service.FlightFareService;


public class RegisterFlightFareUseCase {
     private final FlightFareService flightFareService;

    public RegisterFlightFareUseCase(FlightFareService flightFareService) {
        this.flightFareService = flightFareService;
    }

   public void execute(FlightFare flightFare) {
    flightFareService.RegisterDocument(flightFare);

    }
}
