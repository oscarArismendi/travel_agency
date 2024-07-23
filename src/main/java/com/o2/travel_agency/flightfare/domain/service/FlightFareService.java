package com.o2.travel_agency.flightfare.domain.service;

import java.util.List;

import com.o2.travel_agency.flightfare.domain.entity.FlightFare;

public interface FlightFareService {
    FlightFare createFlightfare(FlightFare flightFare);
    Boolean deleteFlightFareById(Integer id); 
    List<FlightFare> listAllFlightFareUseCase();
    Boolean updateFlightfareById(String updateColumns, int id);
    FlightFare findFlightfareById(Integer id);
}
