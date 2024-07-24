package com.o2.travel_agency.flightfare.infrastructure.in;

import java.util.List;

import com.o2.travel_agency.flightfare.application.DeleteFlightFareByIdUseCase;
import com.o2.travel_agency.flightfare.application.ListAllFlightFareUseCase;
import com.o2.travel_agency.flightfare.application.RegisterFlightFareUseCase;
import com.o2.travel_agency.flightfare.application.UpdateFlightFareByIdUseCase;
import com.o2.travel_agency.flightfare.domain.entity.FlightFare;
import com.o2.travel_agency.utils.ConsoleUtils;
import com.o2.travel_agency.utils.Menus;
import com.o2.travel_agency.utils.MyScanner;

public class FlightFareController {
    private final RegisterFlightFareUseCase registerFlightFareUseCase;
    private final UpdateFlightFareByIdUseCase updateFlightFareByIdUseCase;
    private final DeleteFlightFareByIdUseCase deleteFlightFareByIdUseCase;
    private final ListAllFlightFareUseCase listAllFlightFareUseCase;

    public FlightFareController(RegisterFlightFareUseCase registerFlightFareUseCase,
                                UpdateFlightFareByIdUseCase updateFlightFareByIdUseCase,
                                DeleteFlightFareByIdUseCase deleteFlightFareByIdUseCase,
                                ListAllFlightFareUseCase listAllFlightFareUseCase) {
        this.registerFlightFareUseCase = registerFlightFareUseCase;
        this.updateFlightFareByIdUseCase = updateFlightFareByIdUseCase;
        this.deleteFlightFareByIdUseCase = deleteFlightFareByIdUseCase;
        this.listAllFlightFareUseCase = listAllFlightFareUseCase;
    }

    public void start() {
        while (true) {
            displayMenu();

            int option = ConsoleUtils.option_validation("Choose an option: ", 1, 5);
            switch (option) {
                case 1:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------REGISTER FLIGHTFARE MENU----------------------------------------");
                    registerFlightFareLogic();
                    ConsoleUtils.pause();
                    break;
                case 2:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------UPDATE FLIGHTFARE MENU----------------------------------------");
                    updateFlightFareLogic();
                    ConsoleUtils.pause();
                    break;
                case 3:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------FIND FLIGHTFARE MENU----------------------------------------");
                    consultFlightFareLogic();
                    ConsoleUtils.pause();
                    break;
                case 4:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------DELETE FLIGHTFARE MENU----------------------------------------");
                    deleteFlightFareLogic();
                    ConsoleUtils.pause();
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("----------------------------------------FLIGHTFARE MENU----------------------------------------");
        System.out.println("1. Register Flightfare");
        System.out.println("2. Update Flightfare");
        System.out.println("3. List Flightfare");
        System.out.println("4. Delete Flightfare");
        System.out.println("5. Go back");
    }

    public void deleteFlightFareLogic() {
        try {
            List<FlightFare> flightfareList = listAllFlightFareUseCase.execute();
            if (flightfareList == null) {
                throw new Exception("There is no Flightfare with this id");
            }
            // input a valid flightFare 
            int flightFarePos = Menus.listMenu(flightfareList,"Choose a flightfare to see the delete:");
            FlightFare userFlightfare = flightfareList.get(flightFarePos);
            int id = userFlightfare.getId();
            System.out.println("FlightFare info: ");
            System.out.println("------------------------------------------------------------------------------------------------");
            displayFlightfareDetails(userFlightfare);
            int op =  ConsoleUtils.yesOrNo("Are you sure that you want to remove: " + userFlightfare.toString() + " ?");
            if(op == 1){
                if(!deleteFlightFareByIdUseCase.execute(id)){
                    throw new Exception("Couldn't delete it from the database.");
                }
            }else{
                System.out.println("You have choose to not remove it.");
            }

        } catch (Exception e) {
            System.out.println("Error deleting Flightfare: " + e.getMessage());
        }
    }

    public void registerFlightFareLogic() {
        try {
            System.out.print("Type the Flight fare description: ");
            String description = MyScanner.scanLine();
            if (description.isEmpty()) {
                throw new Exception("You didn't put a description.");
            }
            System.out.print("Type the Flight fare details: ");
            String details = MyScanner.scanLine();
            if (details.isEmpty()) {
                throw new Exception("You didn't put details.");
            }
            System.out.print("Type the Flight fare value: ");
            double value = MyScanner.scanDouble();
            if(value < 0){
                throw new Exception("There can't be negative values!");
            }
            if(registerFlightFareUseCase.execute(new FlightFare(0, description, details, value)) == null){
                throw new Exception("There was an error at creating the flight fare in the database.");
            }
        } catch (Exception e) {
            System.out.println("Error at creating a Flight fare: " + e.getMessage());
        }
    }

    public void updateFlightFareLogic() {
        try {
            List<FlightFare> flightfareList = listAllFlightFareUseCase.execute();
            if (flightfareList == null) {
                throw new Exception("There is no Flightfare with this id");
            }
            // input a valid flightFare 
            int flightFarePos = Menus.listMenu(flightfareList,"Choose a flightfare to see the details:");
            FlightFare userFlightfare = flightfareList.get(flightFarePos);
            int id = userFlightfare.getId();
            System.out.println("FlightFare info: ");
            System.out.println("------------------------------------------------------------------------------------------------");
            displayFlightfareDetails(userFlightfare);
            int op = Menus.classAttributeMenu(userFlightfare.getClass(), "Choose an attribute to update: ");
            String updateColumns = "";
            switch (op) {
                case 0: // description
                    System.out.print("Type the new Flightfare description (current: " + userFlightfare.getDescription() + "): ");
                    String newDescription = MyScanner.scanLine();
                    if (newDescription.isEmpty()) {
                        throw new Exception("You didn't put a description");
                    }
                    updateColumns = "description = '" + newDescription + "'";
                    updateFlightFareByIdUseCase.execute(updateColumns,id);
                    break;
                case 1: // details
                    System.out.print("Type the new Flightfare details (current: " + userFlightfare.getDetails() + "): ");
                    String newDetails = MyScanner.scanLine();
                    if (newDetails.isEmpty()) {
                        throw new Exception("You didn't put details");
                    }
                    updateColumns = "details = '" + newDetails + "'";
                    updateFlightFareByIdUseCase.execute(updateColumns,id);
                    break;
                case 2: // value
                    System.out.print("Type the new Flightfare value (current: " + userFlightfare.getValue() + "): ");
                    double newValue = MyScanner.scanDouble();
                    if(newValue < 0){
                        throw new Exception("There can't be negative values!");
                    }
                    updateColumns = "value = " + newValue;
                    updateFlightFareByIdUseCase.execute(updateColumns,id);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error at updating the Flight fare: " + e.getMessage());
        }
    }

    public void consultFlightFareLogic() {
        try {
            List<FlightFare> flightfareList = listAllFlightFareUseCase.execute();
            if (flightfareList == null) {
                throw new Exception("There are no flight fares in the database!Contact service.");
            }
            // input a valid flightFare 
            int flightFarePos = Menus.listMenu(flightfareList,"Choose a flightfare to see the details:");
            FlightFare flightFare = flightfareList.get(flightFarePos);
            System.out.println("FlightFare info: ");
            System.out.println("------------------------------------------------------------------------------------------------");
            displayFlightfareDetails(flightFare);
        } catch (Exception e) {
            System.out.println("Error finding FlightFare: " + e.getMessage());
        }
    }

    public void displayFlightfareDetails(FlightFare flightFare) {
        System.out.println("Flightfare id: " + flightFare.getId());
        System.out.println("Flightfare description: " + flightFare.getDescription());
        System.out.println("Flightfare details: " + flightFare.getDetails());
        System.out.println("Flightfare value: " + flightFare.getValue());
        System.out.println("------------------------------------------------------------------------------------------------");
    }
}
