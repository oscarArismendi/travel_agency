package com.o2.travel_agency.tripcrew.application;

import com.o2.travel_agency.tripcrew.domain.entity.TripCrew;
import com.o2.travel_agency.tripcrew.domain.service.TripCrewService;

public class RegisterTripCrewUseCase {
     private final TripCrewService tripCrewService;

     public RegisterTripCrewUseCase (TripCrewService tripCrewService){
        this.tripCrewService = tripCrewService;
     }

     public TripCrew execute(TripCrew tripCrew){
        return tripCrewService.RegisterTripCrew(tripCrew);
     }
}
