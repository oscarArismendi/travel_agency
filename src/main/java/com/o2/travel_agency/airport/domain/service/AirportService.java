package com.o2.travel_agency.airport.domain.service;

import com.o2.travel_agency.airport.domain.entity.Airport;


public interface AirportService {
    void createAirport(Airport airport);
    Boolean deleteAirportById(Integer id);
    Airport findAirportById(Integer id);
    Boolean updateAirportById(String updateColumns, int id);
}