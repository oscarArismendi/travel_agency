package com.o2.travel_agency.tripulationRoles.application;

import java.util.List;

import com.o2.travel_agency.tripulationRoles.domain.entity.TripulationRole;
import com.o2.travel_agency.tripulationRoles.domain.service.TripulationRoleService;

public class ListAllTripulationRoleUseCase {
    private final TripulationRoleService tripulationRoleService;

    public ListAllTripulationRoleUseCase(TripulationRoleService tripulationRoleService){
        this.tripulationRoleService = tripulationRoleService;
        }

    public List<TripulationRole> execute(){
        return tripulationRoleService.ListAllTripulationRoles();
    }    
}
