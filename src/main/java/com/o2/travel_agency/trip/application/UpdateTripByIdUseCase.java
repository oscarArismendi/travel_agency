package com.o2.travel_agency.trip.application;

import com.o2.travel_agency.trip.domain.service.TripService;

public class UpdateTripByIdUseCase {
     private final TripService  tripService;

    public UpdateTripByIdUseCase (TripService  tripService) {
        this.tripService = tripService;
    }

    public Boolean execute(String updateColumns, Integer id) {
        return tripService.updateTripById(updateColumns, id);
    }
}
