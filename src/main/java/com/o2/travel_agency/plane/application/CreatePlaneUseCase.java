package com.o2.travel_agency.plane.application;

import com.o2.travel_agency.plane.domain.entity.Plane;
import com.o2.travel_agency.plane.domain.service.PlaneService;

public class CreatePlaneUseCase {
    private final PlaneService planeService;

    public CreatePlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public Plane execute(Plane plane) {
        return planeService.createPlane(plane);
    }
}
