package com.o2.travel_agency.tripcrew.application;

import java.util.List;

import com.o2.travel_agency.tripcrew.domain.entity.TripCrew;
import com.o2.travel_agency.tripcrew.domain.service.TripCrewService;

public class ListAllTripCrewUseCase {
    private final TripCrewService tripCrewService;

    public ListAllTripCrewUseCase(TripCrewService tripCrewService){
        this.tripCrewService = tripCrewService;
    }

    public List<TripCrew> execute(){
        return tripCrewService.listAllTripCrew();
    }
}
