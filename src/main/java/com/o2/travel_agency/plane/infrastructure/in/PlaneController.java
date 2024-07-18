package com.o2.travel_agency.plane.infrastructure.in;

import java.sql.Date;
import java.util.List;

import com.o2.travel_agency.airline.application.ListAllAirlinesUseCase;
import com.o2.travel_agency.airline.domain.entity.Airline;
import com.o2.travel_agency.model.application.ListAllModelsUseCase;
import com.o2.travel_agency.model.domain.entity.Model;
import com.o2.travel_agency.plane.application.CreatePlaneUseCase;
import com.o2.travel_agency.plane.application.FindPlaneByPlateUseCase;

import com.o2.travel_agency.plane.domain.entity.Plane;
import com.o2.travel_agency.status.application.ListAllStatusUseCase;
import com.o2.travel_agency.status.domain.entity.Status;
import com.o2.travel_agency.utils.ConsoleUtils;
import com.o2.travel_agency.utils.Menus;
import com.o2.travel_agency.utils.MyScanner;

public class PlaneController {
    
    private CreatePlaneUseCase createPlaneUseCase;
    private ListAllAirlinesUseCase listAllAirlinesUseCase;
    private ListAllStatusUseCase listAllStatusUseCase;
    private ListAllModelsUseCase listAllModelsUseCase;
    private FindPlaneByPlateUseCase findPlaneByPlateUseCase;








    public PlaneController(CreatePlaneUseCase createPlaneUseCase, ListAllAirlinesUseCase listAllAirlinesUseCase,
            ListAllStatusUseCase listAllStatusUseCase, ListAllModelsUseCase listAllModelsUseCase,
            FindPlaneByPlateUseCase findPlaneByPlateUseCase) {
        this.createPlaneUseCase = createPlaneUseCase;
        this.listAllAirlinesUseCase = listAllAirlinesUseCase;
        this.listAllStatusUseCase = listAllStatusUseCase;
        this.listAllModelsUseCase = listAllModelsUseCase;
        this.findPlaneByPlateUseCase = findPlaneByPlateUseCase;
    }

    public void start() {

        while (true) {
            displayMenu();
            
            int option = ConsoleUtils.option_validation("Choose an option: ", 1, 6);
            switch (option) {
                case 1:
                // create plane
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------CREATE PLANE MENU----------------------------------------");

                    createPlaneLogic();
            
                    ConsoleUtils.pause();

                    break;
                case 2:

                case 3:
                // find plane by plate
                    ConsoleUtils.cleanScreen();
                    System.out.println("-------------------------------------------FIND PLANE MENU----------------------------------------");
                    findPlaneLogic();
                    ConsoleUtils.pause();
                    break;
                case 6:
                    return;
                default:
                    break;
            }            
        }
        
    }

    public void createPlaneLogic(){
        try {
            System.out.print("Type the plane plates: ");
            String plates = MyScanner.scanLine();
            if(findPlaneByPlateUseCase.execute(plates) != null){
                throw new Exception("There is already a plane with this plates");
            }
            if(plates.length() == 0){
                throw new Exception("You didn't put plates");
            }
            System.out.print("Type the plane capacity: ");
            int capacity = MyScanner.scanInt();
            if(capacity <= 0){
                throw new Exception("There can't be a plane without capacity");
            }
            Date  date  = ConsoleUtils.validateDate("Type the fabication date: ");

            // airline show all airlines, return a list
            List<Airline> airlines =  listAllAirlinesUseCase.execute();
            if(airlines.size() ==  0){
                throw new Exception("There is not airlines in the database! contact service.");
            }
            //  input a validad  airline
            int airlinePos =  Menus.listMenu(airlines,"Choose an airline:");
            int airlineId = airlines.get(airlinePos).getId();

            // status show all status, return a list
            List<Status> status =  listAllStatusUseCase.execute();
            if(status.size() ==  0){
                throw new Exception("There is not status in the database! contact service.");
            }
            // input a valid status
            int statusPos = Menus.listMenu(status,"Choose a status:");
            int statusId = status.get(statusPos).getId();
            

            // models show all models, return a list
            List<Model> models = listAllModelsUseCase.execute();
            if(models.size() == 0){
                throw new Exception("There is not model in the database! contact service.");
            }
            // input a valid model
            int modelPos = Menus.listMenu(models,"Choose a model:");
            int modelId = models.get(modelPos).getId();


            Plane plane = new Plane(modelId, plates, capacity, date, airlineId, statusId, modelId);

            createPlaneUseCase.execute(plane);
            System.out.println("Plane created successfully!");

        }catch (Exception e) {
            System.out.println("Error at creating a plane: " + e.getMessage());
        }
    }

    public void findPlaneLogic(){
        try {
            System.out.println("Enter plate: ");
            String plate = MyScanner.scanLine();
            Plane plane = findPlaneByPlateUseCase.execute(plate);
            displayPlaneDetails(plane);
        } catch (Exception e) {
            System.out.println("Invalid plate.");
        }
    }

    public void displayMenu() {
        ConsoleUtils.cleanScreen();
        System.out.println("----------------------------------------PLANE MENU----------------------------------------");
        System.out.println("1. Create Plane");
        System.out.println("2. Update Plane");
        System.out.println("3. Find Plane");
        System.out.println("4. Delete Plane");
        System.out.println("5. List all Planes");
        System.out.println("6. Go back");
    }

    public void displayPlaneDetails(Plane plane){
        System.out.println("Plane id: " + plane.getId());
        System.out.println("Plane plates: " + plane.getPlates());
        System.out.println("Plane capacity: " + plane.getCapacity());
        System.out.println("Plane fabrication date: " + plane.getFabricationDate());
        System.out.println("Plane id airline: "+ plane.getIdAirline() );
        System.out.println("Plane id status: "+ plane.getIdStatus());
        System.out.println("Plane id model: "+ plane.getIdModel());
    }

}
