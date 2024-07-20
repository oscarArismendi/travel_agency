package com.o2.travel_agency;

import com.o2.travel_agency.airline.application.ListAllAirlinesUseCase;
import com.o2.travel_agency.airline.domain.service.AirlineService;
import com.o2.travel_agency.airline.infrastructure.out.AirlineRepository;
import com.o2.travel_agency.model.application.ListAllModelsUseCase;
import com.o2.travel_agency.model.domain.service.ModelService;
import com.o2.travel_agency.model.infrastructure.out.ModelRepository;
import com.o2.travel_agency.plane.application.CreatePlaneUseCase;
import com.o2.travel_agency.plane.application.FindPlaneByPlateUseCase;
import com.o2.travel_agency.plane.application.UpdatePlaneByPlateUseCase;
import com.o2.travel_agency.plane.domain.service.PlaneService;
import com.o2.travel_agency.plane.infrastructure.in.PlaneController;
import com.o2.travel_agency.plane.infrastructure.out.PlaneRepository;
import com.o2.travel_agency.status.application.ListAllStatusUseCase;
import com.o2.travel_agency.status.domain.service.StatusService;
import com.o2.travel_agency.status.infrastructure.out.StatusRepository;

public class Main {
    public static void main(String[] args) {
        //airline setion
        AirlineService airlineService = new AirlineRepository();
        ListAllAirlinesUseCase listAllAirlinesUseCase = new ListAllAirlinesUseCase(airlineService);

        // status section
        StatusService statusService = new StatusRepository();
        ListAllStatusUseCase listAllStatusUseCase = new ListAllStatusUseCase(statusService);

        // model section
        ModelService modelService = new ModelRepository();
        ListAllModelsUseCase listAllModelsUseCase = new ListAllModelsUseCase(modelService);
        
        // plane section
        PlaneService planeService = new PlaneRepository();
        CreatePlaneUseCase createPlaneUseCase = new  CreatePlaneUseCase(planeService);
        FindPlaneByPlateUseCase findPlaneByPlateUseCase = new FindPlaneByPlateUseCase(planeService);
        UpdatePlaneByPlateUseCase updatePlaneByPlateUseCase = new UpdatePlaneByPlateUseCase(planeService);
        PlaneController planeController  = new PlaneController(createPlaneUseCase,listAllAirlinesUseCase,listAllStatusUseCase,listAllModelsUseCase,findPlaneByPlateUseCase,updatePlaneByPlateUseCase);

        planeController.start();
    }
}