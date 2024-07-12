package com.o2.travel_agency.plane.application;

import com.o2.travel_agency.plane.domain.entity.Plane;
import com.o2.travel_agency.plane.domain.service.PlaneService;

public class CreatePlaneUseCase {
    private final PlaneService planeService;

    public CreatePlaneUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public void execute(Plane plane) {
        planeService.createPlane(plane);
    }
}
