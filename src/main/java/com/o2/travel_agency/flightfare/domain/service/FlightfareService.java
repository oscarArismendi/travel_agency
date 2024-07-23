package com.o2.travel_agency.flightfare.domain.service;

import java.util.List;

import com.o2.travel_agency.flightfare.domain.entity.FlightFare;

public interface FlightfareService {
    void RegisterDocument(FlightFare flightFare);
    Boolean deleteFlightFareTypeById(Integer id); 
    List<FlightFare> ListAllFlightFareUseCase();
}
