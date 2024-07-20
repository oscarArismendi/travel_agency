package com.o2.travel_agency.plane.application;

import com.o2.travel_agency.plane.domain.service.PlaneService;

public class DeletePlaneByIdUseCase {
    private final PlaneService planeService;

    public DeletePlaneByIdUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public Boolean execute(Integer id) {
        return planeService.deletePlaneById(id);
    }
}
