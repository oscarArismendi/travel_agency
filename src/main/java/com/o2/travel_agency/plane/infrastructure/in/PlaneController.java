package com.o2.travel_agency.plane.infrastructure.in;

import java.sql.Date;
import java.util.List;

import com.o2.travel_agency.airline.application.ListAllAirlinesUseCase;
import com.o2.travel_agency.airline.domain.entity.Airline;
import com.o2.travel_agency.model.application.ListAllModelsUseCase;
import com.o2.travel_agency.model.domain.entity.Model;
import com.o2.travel_agency.plane.application.CreatePlaneUseCase;
import com.o2.travel_agency.plane.application.DeletePlaneByIdUseCase;
import com.o2.travel_agency.plane.application.FindPlaneByPlateUseCase;
import com.o2.travel_agency.plane.application.FindPlaneStMdByIdUseCase;
import com.o2.travel_agency.plane.application.UpdatePlaneByPlateUseCase;
import com.o2.travel_agency.plane.domain.entity.Plane;
import com.o2.travel_agency.plane.domain.entity.PlaneStMdDTO;
import com.o2.travel_agency.revision.application.ListAllRevisionsUseCase;
import com.o2.travel_agency.revision.domain.entity.Revision;
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
    private UpdatePlaneByPlateUseCase updatePlaneByPlate;
    private DeletePlaneByIdUseCase deletePlaneByIdUseCase;
    private ListAllRevisionsUseCase  listAllRevisionsUseCase;
    private FindPlaneStMdByIdUseCase findPlaneStMdByIdUseCase;




    public PlaneController(CreatePlaneUseCase createPlaneUseCase, ListAllAirlinesUseCase listAllAirlinesUseCase,
            ListAllStatusUseCase listAllStatusUseCase, ListAllModelsUseCase listAllModelsUseCase,
            FindPlaneByPlateUseCase findPlaneByPlateUseCase, UpdatePlaneByPlateUseCase updatePlaneByPlate,
            DeletePlaneByIdUseCase deletePlaneByIdUseCase, ListAllRevisionsUseCase listAllRevisionsUseCase,
            FindPlaneStMdByIdUseCase findPlaneStMdByIdUseCase) {
        this.createPlaneUseCase = createPlaneUseCase;
        this.listAllAirlinesUseCase = listAllAirlinesUseCase;
        this.listAllStatusUseCase = listAllStatusUseCase;
        this.listAllModelsUseCase = listAllModelsUseCase;
        this.findPlaneByPlateUseCase = findPlaneByPlateUseCase;
        this.updatePlaneByPlate = updatePlaneByPlate;
        this.deletePlaneByIdUseCase = deletePlaneByIdUseCase;
        this.listAllRevisionsUseCase = listAllRevisionsUseCase;
        this.findPlaneStMdByIdUseCase = findPlaneStMdByIdUseCase;
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
                // update plane
                ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------UPDATE PLANE MENU----------------------------------------");
                    
                    updatePlaneLogic();

                    ConsoleUtils.pause();

                    break;
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
            if(createPlaneUseCase.execute(plane) != null){

                System.out.println("Plane created successfully!");
            }else{
                throw new Exception("Error at inserting plane in the database");
            }

        }catch (Exception e) {
            System.out.println("Error at creating a plane: " + e.getMessage());
        }
    }

    public void maintenanceHistoryLogic(){
        try {
            System.out.print("Type the plane plates: ");
            String plates = MyScanner.scanLine();
            if(plates.length() == 0){
                throw new Exception("You didn't put plates");
            }
            Plane plane = findPlaneByPlateUseCase.execute(plates);
            if(plane == null){
                throw new Exception("There is no plane with this plates");
            }
            List<Revision> revisions =  listAllRevisionsUseCase.execute();
            int cntRevision = 0;
            for(Revision revision :  revisions){
                if(revision.getIdPlane() == plane.getId()){
                    System.out.println("- "+revision.toString());
                    cntRevision++;
                }
            }
            if(cntRevision == 0){
                System.out.println("This plane hasn't revision,contact someone from maintenance department");
            }
        } catch (Exception e) {
            System.out.println("Error at Consult Plane Maintenance History: " + e.getMessage());
        }
    }

    public void findPlaneLogic(){
        try {
            System.out.println("Enter plate: ");
            String plate = MyScanner.scanLine();
            Plane plane = findPlaneByPlateUseCase.execute(plate);
            displayPlaneFullDetails(plane);
        } catch (Exception e) {
            System.out.println("Invalid plate.");
        }
    }

    public void deletePlaneLogic(){
        try {
            System.out.println("Enter plate: ");
            String plate = MyScanner.scanLine();
            Plane plane = findPlaneByPlateUseCase.execute(plate);
            deletePlaneByIdUseCase.execute(plane.getId());
        } catch (Exception e) {
            System.out.println("Invalid plate.");
        }
    }

    public void updatePlaneLogic(){
        try {
            System.out.print("Type the plane plates: ");
            String plates = MyScanner.scanLine();
            if(plates.length() == 0){
                throw new Exception("You didn't put plates");
            }
            Plane plane = findPlaneByPlateUseCase.execute(plates);
            if( plane == null){
                throw new Exception("There no plane with this plates");
            }
            System.out.println("Plane info: ");
            displayPlaneFullDetails(plane);
            int op = Menus.classAttributeMenu(plane.getClass(),"Choose a attribute to update: ");
            String updateColumns = "plates = " ;
            switch(op){
                case 0:// plates
                    System.out.print("Type the new plane plates (actual: "+ plane.getPlates()  + " ): ");
                    String newPlates = MyScanner.scanLine();
                    if(findPlaneByPlateUseCase.execute(newPlates) != null){
                        throw new Exception("There is already a plane with this plates");
                    }
                    if(newPlates.length() == 0){
                        throw new Exception("You didn't put plates");
                    }
                    updateColumns = "plates = " ;
                    updateColumns += ("'"+ newPlates +"'");
                    
                    updatePlaneByPlate.execute(updateColumns,plane.getPlates());
                    break;
                case 1:// capacity
                    System.out.print("Type the new plane capacity (actual: "+ plane.getCapacity()+ " ): ");
                    int newCapacity = MyScanner.scanInt();
                    if(newCapacity <= 0){
                        throw new Exception("There can't be a plane without capacity");
                    }
                    updateColumns = "capacity = " ;
                    updateColumns += newCapacity;
                    updatePlaneByPlate.execute(updateColumns,plane.getPlates());
                    break;
                case 2:// fabricationDate
                    Date  newDate  = ConsoleUtils.validateDate("Type the fabication date (actual:" + plane.getFabricationDate() + " ): ");
                    updateColumns = "fabricationDate = " ;
                    updateColumns += ("'"+newDate.toString()+"'") ;
                    updatePlaneByPlate.execute(updateColumns,plates);
                    break;
                case 3:// idAirline
                    List<Airline> airlines =  listAllAirlinesUseCase.execute();
                    if(airlines.size() ==  0){
                        throw new Exception("There is not airlines in the database! contact service.");
                    }
                    //  input a validad  airline
                    int airlinePos =  Menus.listMenu(airlines,"Choose an airline:");
                    int airlineId = airlines.get(airlinePos).getId();

                    updateColumns = "idAirline = " ;
                    updateColumns += airlineId ;
                    updatePlaneByPlate.execute(updateColumns,plates);
                    break;
                case 4:// idStatus
                    List<Status> status =  listAllStatusUseCase.execute();
                    if(status.size() ==  0){
                        throw new Exception("There is not status in the database! contact service.");
                    }
                    // input a valid status
                    int statusPos = Menus.listMenu(status,"Choose a status:");
                    int statusId = status.get(statusPos).getId();

                    updateColumns = "idStatus = " ;
                    updateColumns += statusId ;
                    updatePlaneByPlate.execute(updateColumns,plates);
                    break;
                case 5:// idModel
                    List<Model> models = listAllModelsUseCase.execute();
                    if(models.size() == 0){
                        throw new Exception("There is not model in the database! contact service.");
                    }
                    // input a valid model
                    int modelPos = Menus.listMenu(models,"Choose a model:");
                    int modelId = models.get(modelPos).getId();

                    updateColumns = "idModel = " ;
                    updateColumns += modelId ;
                    updatePlaneByPlate.execute(updateColumns,plates);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error at updating the plane: " + e.getMessage());
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
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    public void displayPlaneFullDetails(Plane plane){
        PlaneStMdDTO planeStMdDTO = findPlaneStMdByIdUseCase.execute(plane.getId());
        System.out.println("Plane id: " + planeStMdDTO.getId());
        System.out.println("Plane plates: " + planeStMdDTO.getPlates());
        System.out.println("Plane capacity: " + planeStMdDTO.getCapacity());
        System.out.println("Plane fabrication date: " + planeStMdDTO.getFabricationDate());
        System.out.println("Plane airline: "+ planeStMdDTO.getNameAirline() );
        System.out.println("Plane status: "+ planeStMdDTO.getNameStatus());
        System.out.println("Plane model: "+ planeStMdDTO.getNameModel());
        System.out.println("------------------------------------------------------------------------------------------------");
    }

}
