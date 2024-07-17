package com.o2.travel_agency.plane.application;

import com.o2.travel_agency.plane.domain.entity.Plane;
import com.o2.travel_agency.plane.domain.service.PlaneService;

public class FindPlaneByPlateUseCase {
    private final PlaneService planeService;

    public FindPlaneByPlateUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public Plane execute(String plate) {
        return planeService.findPlaneByPlate(plate);
    }

}
