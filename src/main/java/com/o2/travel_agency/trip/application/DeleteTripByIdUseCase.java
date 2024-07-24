package com.o2.travel_agency.trip.application;

import com.o2.travel_agency.trip.domain.service.TripService;

public class DeleteTripByIdUseCase {
    private final TripService  tripService;

    public  DeleteTripByIdUseCase(TripService  tripService) {
        this.tripService = tripService;
    }

    public Boolean execute(Integer id) {
        return tripService.deleteDocumentTypeById(id);
    }
}
