package com.o2.travel_agency.plane.application;

import com.o2.travel_agency.plane.domain.service.PlaneService;

public class UpdatePlaneByPlateUseCase {
    private final PlaneService planeService;

    public UpdatePlaneByPlateUseCase(PlaneService planeService) {
        this.planeService = planeService;
    }

    public Boolean execute(String updateColumns, String plate) {
        return planeService.updatePlaneByPlate(updateColumns, plate);
    }
}
