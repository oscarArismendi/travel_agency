package com.o2.travel_agency.plane.domain.service;

import com.o2.travel_agency.plane.domain.entity.Plane;

public interface PlaneService {
    Plane createPlane(Plane plane);
    Plane findPlaneByPlate(String plate);
    Boolean updatePlaneByPlate(String updateColumns,String plate);
    Boolean deletePlaneById(Integer id);
}
