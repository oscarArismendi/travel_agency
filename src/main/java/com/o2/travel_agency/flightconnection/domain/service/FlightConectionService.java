package com.o2.travel_agency.flightconnection.domain.service;

import java.util.List;

import com.o2.travel_agency.flightconnection.domain.entity.FlightConnection;

public interface FlightConectionService {

    List<FlightConnection> listAllFlightConnection();

    Boolean deleteFlightConnectionById(Integer id);

    Boolean updateFlightConneciontById(String updateColumns, Integer id);

}
