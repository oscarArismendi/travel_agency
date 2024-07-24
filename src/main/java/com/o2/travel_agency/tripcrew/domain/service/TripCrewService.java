package com.o2.travel_agency.tripcrew.domain.service;

import java.util.List;

import com.o2.travel_agency.tripcrew.domain.entity.TripCrew;

public interface TripCrewService {

    List<TripCrew> listAllTripCrew();
    TripCrew RegisterTripCrew(TripCrew tripCrew); 
    
}
