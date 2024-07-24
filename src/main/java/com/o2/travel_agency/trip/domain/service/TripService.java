package com.o2.travel_agency.trip.domain.service;

import java.util.List;

import com.o2.travel_agency.trip.domain.entity.Trip;

public interface TripService {

    List<Trip> listAllTrip();

    Boolean updateTripById(String updateColumns, Integer id);

    Boolean deleteDocumentTypeById(Integer id);

}
