package com.o2.travel_agency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.o2.travel_agency.airline.application.ListAllAirlinesUseCase;
import com.o2.travel_agency.airline.domain.service.AirlineService;
import com.o2.travel_agency.airline.infrastructure.out.AirlineRepository;
import com.o2.travel_agency.model.application.ListAllModelsUseCase;
import com.o2.travel_agency.model.domain.service.ModelService;
import com.o2.travel_agency.model.infrastructure.out.ModelRepository;
import com.o2.travel_agency.plane.application.CreatePlaneUseCase;
import com.o2.travel_agency.plane.application.DeletePlaneByIdUseCase;
import com.o2.travel_agency.plane.application.FindPlaneByPlateUseCase;
import com.o2.travel_agency.plane.application.UpdatePlaneByPlateUseCase;
import com.o2.travel_agency.plane.domain.service.PlaneService;
import com.o2.travel_agency.plane.infrastructure.in.PlaneController;
import com.o2.travel_agency.plane.infrastructure.out.PlaneRepository;
import com.o2.travel_agency.status.application.ListAllStatusUseCase;
import com.o2.travel_agency.status.domain.service.StatusService;
import com.o2.travel_agency.status.infrastructure.out.StatusRepository;
import com.o2.travel_agency.utils.ConsoleUtils;
import com.o2.travel_agency.utils.Menus;

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
        DeletePlaneByIdUseCase  deletePlaneByIdUseCase = new DeletePlaneByIdUseCase(planeService);
        PlaneController planeController  = new PlaneController(createPlaneUseCase,listAllAirlinesUseCase,listAllStatusUseCase,listAllModelsUseCase,findPlaneByPlateUseCase,updatePlaneByPlateUseCase,deletePlaneByIdUseCase);

        String userRol = "ADMIN";
        int[] holderAccess = {1,8,10,11,12,15,16,20,21};
        List<String> useCases = Arrays.asList(
            "Register Plane",  // 1
            "Assign Crew to Route",  // 2
            "Create Flight Reservation",  // 3
            "Register Maintenance Review",  // 4
            "Consult Customer Information",  // 5
            "Consult Flight Reservation",  // 6
            "Register Customer",  // 7
            "Consult Plane Information",  // 8
            "Consult Route Information",  // 9
            "Register Airport",  // 10
            "Consult Airport Information",  // 11
            "Consult Plane Maintenance History",  // 12
            "Update Customer Information",  // 13
            "Delete Flight Reservation",  // 14
            "Update Plane Information",  // 15
            "Delete Plane",  // 16
            "Assign Plane to Route",  // 17
            "Update Route Information",  // 18
            "Delete Route",  // 19
            "Update Airport Information",  // 20
            "Delete Airport",  // 21
            "Update Customer Information",  // 22
            "Consult Flight Information",  // 23
            "Update Maintenance Review Information",  // 24
            "Delete Maintenance Review",  // 25
            "Consult Crew Assignment",  // 26
            "Consult Route Stops",  // 27
            "Update Stop Information",  // 28
            "Delete Stop",  // 29
            "Register Flight Fare",  // 30
            "Update Flight Fare Information",  // 31
            "Delete Flight Fare",  // 32
            "Consult Flight Fare",  // 33
            "Register Document Type",  // 34
            "Update Document Type",  // 35
            "Delete Document Type",  // 36
            "Consult Document Type",  // 37
            "Search Flights",  // 38
            "Select Flight",  // 39
            "Add Passengers",  // 40
            "Select Seats",  // 41
            "Make Payment",  // 42
            "Consult Flight Reservation",  // 43
            "Cancel Flight Reservation",  // 44
            "Modify Flight Reservation"  // 45
        );
        List<String> userPermisions = new ArrayList<>();
        for(int i : holderAccess){
            userPermisions.add(useCases.get(i-1));
        }
        userPermisions.add("Exit");
        
        
        while (true) {
            ConsoleUtils.cleanScreen();
            System.out.println("------------------------"+ userRol+ " MENU--------------------------------------");
            String menuChoose = Menus.mainMenu(userPermisions,"User menus: ");
            switch (menuChoose) {
                case "Register Plane"://1
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------CREATE PLANE MENU----------------------------------------");
                    planeController.createPlaneLogic();
                    ConsoleUtils.pause();
                    break;
                case "Consult Plane Information"://8
                    ConsoleUtils.cleanScreen();
                    System.out.println("-------------------------------------------FIND PLANE MENU----------------------------------------");
                    planeController.findPlaneLogic();
                    ConsoleUtils.pause();
                    break;
                case "Register Airport"://10
                    ConsoleUtils.cleanScreen();
                    System.out.println("-------------------------------------------CREATE AIRPORT MENU--------------------------------------");
                    ConsoleUtils.pause();
                    break;
                case "Consult Airport Information"://11
                    ConsoleUtils.cleanScreen();
                    System.out.println("-------------------------------------------FIND AIRPORT MENU----------------------------------------");
                    ConsoleUtils.pause();
                break;
                case "Consult Plane Maintenance History"://12
                    ConsoleUtils.cleanScreen();
                    System.out.println("---------------------------------------PLANE MAINTENANCE HISTORY MENU-------------------------------");
                    ConsoleUtils.pause();
                case "Update Plane Information"://15
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------UPDATE PLANE MENU----------------------------------------");
                    planeController.updatePlaneLogic();
                    ConsoleUtils.pause();
                    break;
                case "Delete Plane"://16
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------DELETE PLANE MENU----------------------------------------");
                    planeController.deletePlaneLogic();
                    ConsoleUtils.pause();
                    break;
                case "Update Airport Information"://20
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------UPDATE AIRPORT MENU-----------------------------------------");
                    ConsoleUtils.pause();
                    break;
                case "Delete Airport"://21
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------DELETE AIRPORT MENU-----------------------------------------");
                    ConsoleUtils.pause();
                    break;
                case "Exit":
                    System.out.println("Have a good day!");
                    return;
                default:
                    break;
            }
        }

    }


}