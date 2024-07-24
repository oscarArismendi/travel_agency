package com.o2.travel_agency.trip.infrastructure.in;

import java.util.List;

import com.o2.travel_agency.trip.application.DeleteTripByIdUseCase;
import com.o2.travel_agency.trip.application.ListAllTripUseCase;
import com.o2.travel_agency.trip.application.UpdateTripByIdUseCase;
import com.o2.travel_agency.trip.domain.entity.Trip;
import com.o2.travel_agency.utils.ConsoleUtils;
import com.o2.travel_agency.utils.Menus;
import com.o2.travel_agency.utils.MyScanner;

public class TripController {
    private final UpdateTripByIdUseCase updateTripByIdUseCase;
    private final DeleteTripByIdUseCase deleteTripByIdUseCase;
    private final ListAllTripUseCase listAllTripUseCase;

    public TripController(UpdateTripByIdUseCase updateTripByIdUseCase,
    DeleteTripByIdUseCase deleteTripByIdUseCase,
    ListAllTripUseCase listAllTripUseCase) {
this.updateTripByIdUseCase = updateTripByIdUseCase;
this.deleteTripByIdUseCase = deleteTripByIdUseCase;
this.listAllTripUseCase = listAllTripUseCase;
}

public void start() {
        while (true) {
            displayMenu();

            int option = ConsoleUtils.option_validation("Choose an option: ", 1, 5);
            switch (option) {
              
                case 1:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------UPDATE TRIP MENU----------------------------------------");
                    updateTripLogic();
                    ConsoleUtils.pause();
                    break;
                case 2:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------LIST TRIP MENU----------------------------------------");
                    listTripLogic();
                    ConsoleUtils.pause();
                    break;
                case 3:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------DELETE TRIP MENU----------------------------------------");
                    deleteTripLogic();
                    ConsoleUtils.pause();
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("----------------------------------------TRIP MENU----------------------------------------");
        System.out.println("1. Update Trip");
        System.out.println("2. List Trip");
        System.out.println("3. Delete Trip");
        System.out.println("4. Go back");
    }

    public void deleteTripLogic() {
        try {
            System.out.print("Enter Trip id to delete: ");
            int id = MyScanner.scanInt();
            List<Trip> tripList = listAllTripUseCase.execute();
            if (tripList == null) {
                throw new Exception("There aren't trips in this database! Contact service");
            }
            Trip userTrip = null;
            for (Trip trip : tripList){
                if(trip.getId() == id){
                    userTrip = trip;
                    break;
                }
            }
            if(userTrip == null){
                throw new Exception("There is no trip with this id");
            }
            int op =  ConsoleUtils.yesOrNo("Are you sure that you want to remove: " + userTrip.toString() + " ?");
            if(op == 1){
                if(!deleteTripByIdUseCase.execute(id)){
                    throw new Exception("Couldn't find a trip with the id " + id);
                }
            }else{
                System.out.println("You have chosen to not remove it.");
            }
        } catch (Exception e) {
            System.out.println("Error deleting Trip: " + e.getMessage());
        }
    }


    public void updateTripLogic() {
        try {
            List<Trip> tripList = listAllTripUseCase.execute();
            if (tripList == null) {
                throw new Exception("There aren't trips in this database! Contact service");
            }
            // input a valid trip
            int tripPos = Menus.listMenu(tripList,"Choose a trip:");
            Trip trip = tripList.get(tripPos);
            int tripId = trip.getId();
            System.out.println("Trip info: ");
            displayTripDetails(trip);
            int op = Menus.classAttributeMenu(trip.getClass(), "Choose an attribute to update: ");
            String updateColumns = "";
            switch (op) {
                case 0: // tripDate
                    System.out.print("Type the new trip date (current: " + trip.getTripDate() + "): ");
                    String newTripDate = MyScanner.scanLine();
                    if (newTripDate.isEmpty()) {
                        throw new Exception("You didn't put a date");
                    }
                    updateColumns = "tripDate = '" + newTripDate + "'";
                    updateTripByIdUseCase.execute(updateColumns, tripId);
                    break;
                case 1: // priceTrip
                    System.out.print("Type the new trip price (current: " + trip.getPriceTrip() + "): ");
                    double newPriceTrip = MyScanner.scanDouble();
                    updateColumns = "priceTrip = " + newPriceTrip;
                    updateTripByIdUseCase.execute(updateColumns, tripId);
                    break;
                case 2: // idOrigin
                    System.out.print("Type the new origin airport id (current: " + trip.getIdOrigin() + "): ");
                    int newIdOrigin = MyScanner.scanInt();
                    updateColumns = "idOrigin = " + newIdOrigin;
                    updateTripByIdUseCase.execute(updateColumns, tripId);
                    break;
                case 3: // idDestination
                    System.out.print("Type the new destination airport id (current: " + trip.getIdDestination() + "): ");
                    int newIdDestination = MyScanner.scanInt();
                    updateColumns = "idDestination = " + newIdDestination;
                    updateTripByIdUseCase.execute(updateColumns, tripId);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error at updating the trip: " + e.getMessage());
        }
    }

    public void listTripLogic() {
        try {
            List<Trip> tripList = listAllTripUseCase.execute();
            if (tripList == null) {
                throw new Exception("There aren't trips in this database! Contact service");
            }
            for (Trip trip : tripList) {
                displayTripDetails(trip);
            }
        } catch (Exception e) {
            System.out.println("Error listing trips: " + e.getMessage());
        }
    }

    public void displayTripDetails(Trip trip) {
        System.out.println("Trip id: " + trip.getId());
        System.out.println("Trip date: " + trip.getTripDate());
        System.out.println("Trip price: " + trip.getPriceTrip());
        System.out.println("Origin airport id: " + trip.getIdOrigin());
        System.out.println("Destination airport id: " + trip.getIdDestination());
        System.out.println("------------------------------------------------------------------------------------------------");
    }


}
