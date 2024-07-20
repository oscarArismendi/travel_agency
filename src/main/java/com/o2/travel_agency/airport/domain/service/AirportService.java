package com.o2.travel_agency.airport.domain.service;

import com.o2.travel_agency.airport.domain.entity.Airport;
import com.o2.travel_agency.airport.infrastructure.out.AirportRepository;

public class AirportService {
    private AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public void saveAirport(Airport airport) {
        airportRepository.save(airport);
    }
}