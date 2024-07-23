package com.o2.travel_agency.flightfare.application;


import com.o2.travel_agency.flightfare.domain.entity.FlightFare;

import com.o2.travel_agency.flightfare.domain.service.FlightfareService;


public class RegisterFlightFareUseCase {
    private final FlightfareService flightFareService;

    public RegisterFlightFareUseCase(FlightfareService flightFareService) {
        this.flightFareService = flightFareService;
    }

   public void execute(FlightFare flightFare) {
    flightFareService.RegisterDocument(flightFare);

    }
}
