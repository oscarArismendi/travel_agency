package com.o2.travel_agency.airport.infrastructure.in;

import com.o2.travel_agency.airport.application.RegisterAirportUseCase;
import com.o2.travel_agency.airport.domain.service.AirportService;
import com.o2.travel_agency.airport.infrastructure.out.AirportRepository;

public class AirportController {
    private RegisterAirportUseCase registerAirportUseCase;

    public AirportController() {
        AirportRepository airportRepository = new AirportRepository();
        AirportService airportService = new AirportService(airportRepository);
        this.registerAirportUseCase = new RegisterAirportUseCase(airportService);
    }

    public void registerAirport(int id, String name, String city, String country) {
        registerAirportUseCase.registerAirport(id, name, city, country);
    }
}
