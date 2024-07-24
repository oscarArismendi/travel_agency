package com.o2.travel_agency.trip.application;

import java.util.List;

import com.o2.travel_agency.trip.domain.entity.Trip;
import com.o2.travel_agency.trip.domain.service.TripService;


public class ListAllTripUseCase {
     private final TripService  tripService;

    public ListAllTripUseCase (TripService tripService) {
        this.tripService = tripService;
    }
    
    public  List<Trip> execute(){
        return tripService.listAllTrip();
    }
}
