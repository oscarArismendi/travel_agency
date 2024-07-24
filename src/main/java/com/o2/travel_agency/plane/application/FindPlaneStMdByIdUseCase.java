package com.o2.travel_agency.plane.application;

import com.o2.travel_agency.plane.domain.entity.PlaneStMdDTO;
import com.o2.travel_agency.plane.domain.service.PlaneService;

public class FindPlaneStMdByIdUseCase {
    private final PlaneService planeService;

    public FindPlaneStMdByIdUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public PlaneStMdDTO execute(int id) {
        return planeService.findPlaneStMdById(id);
    }
}
