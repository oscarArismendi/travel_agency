package com.o2.travel_agency.trip.infrastructure.in;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.o2.travel_agency.employee.application.ListAllEmployeesUseCase;
import com.o2.travel_agency.employee.domain.entity.Employee;
import com.o2.travel_agency.flightconnection.application.ListAllFlightConnectionUseCase;
import com.o2.travel_agency.flightconnection.domain.entity.FlightConnection;
import com.o2.travel_agency.trip.application.DeleteTripByIdUseCase;
import com.o2.travel_agency.trip.application.ListAllTripUseCase;
import com.o2.travel_agency.trip.application.UpdateTripByIdUseCase;
import com.o2.travel_agency.trip.domain.entity.Trip;
import com.o2.travel_agency.tripcrew.application.ListAllTripCrewUseCase;
import com.o2.travel_agency.tripcrew.domain.entity.TripCrew;
import com.o2.travel_agency.utils.ConsoleUtils;
import com.o2.travel_agency.utils.Menus;
import com.o2.travel_agency.utils.MyScanner;

public class TripController {
    private final UpdateTripByIdUseCase updateTripByIdUseCase;
    private final DeleteTripByIdUseCase deleteTripByIdUseCase;
    private final ListAllTripUseCase listAllTripUseCase;
    private final ListAllFlightConnectionUseCase listAllFlightConnectionUseCase;
    private final ListAllTripCrewUseCase listAllTripCrewUseCase;
    private final ListAllEmployeesUseCase listAllEmployeesUseCase;

    

    public TripController(UpdateTripByIdUseCase updateTripByIdUseCase, DeleteTripByIdUseCase deleteTripByIdUseCase,
            ListAllTripUseCase listAllTripUseCase, ListAllFlightConnectionUseCase listAllFlightConnectionUseCase,
            ListAllTripCrewUseCase listAllTripCrewUseCase, ListAllEmployeesUseCase listAllEmployeesUseCase) {
        this.updateTripByIdUseCase = updateTripByIdUseCase;
        this.deleteTripByIdUseCase = deleteTripByIdUseCase;
        this.listAllTripUseCase = listAllTripUseCase;
        this.listAllFlightConnectionUseCase = listAllFlightConnectionUseCase;
        this.listAllTripCrewUseCase = listAllTripCrewUseCase;
        this.listAllEmployeesUseCase = listAllEmployeesUseCase;
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
                    ConsultTripLCrewAssingmentLogic();
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

    public void ConsultTripLCrewAssingmentLogic() {
        try {
            
            List<Trip> tripList = listAllTripUseCase.execute();
            if (tripList.size() == 0) {
                throw new Exception("There aren't trips in this database! Contact service");
            }
            //  input a valid trip
            int tripPos =  Menus.listMenu(tripList,"Choose a trip:");
            Trip trip = tripList.get(tripPos);
            int tripId = trip.getId();
            // flightConnection list
            List<FlightConnection> flightConnectionsList = listAllFlightConnectionUseCase.execute();
            if (flightConnectionsList.size() == 0) {
                throw new Exception("There aren't flight connections for this trip in the database! Contact service");
            }
            flightConnectionsList.removeIf(obj -> obj.getIdTrip() != tripId);
            if(flightConnectionsList.size() ==  0){
                throw new Exception("There are not flight connections related to the trip ( "+ trip.toString() + ") in the database! contact service.");
            }
             //  input a valid flight connection
            int flightConnectionPos =  Menus.listMenu(flightConnectionsList,"Choose a flight connection to see the crew:");
            FlightConnection flightConnection = flightConnectionsList.get(flightConnectionPos);
            int flightConnectionId = flightConnection.getId();
            //list tripcrew
            List<TripCrew> tripCrewList = listAllTripCrewUseCase.execute();
            if (tripCrewList.size() == 0) {
                throw new Exception("Nobody is assign to this flight connection in this database! Contact service");
            }
            tripCrewList.removeIf(obj -> obj.getIdConection() != flightConnectionId);
            //List employees
            List<Employee> employeesList = listAllEmployeesUseCase.execute();
            if (employeesList.size() == 0) {
                throw new Exception("Unable to find the employees for this flight connection in this database! Contact service");
            }
            Set<Integer> assignedEmployeeIds = new HashSet<>();
            for(TripCrew crew :  tripCrewList){
                assignedEmployeeIds.add(crew.getIdEmployees());
            }
            employeesList.removeIf(obj -> !assignedEmployeeIds.contains(obj.getId()));
            if (employeesList.size() == 0) {
                throw new Exception("Unable to find the employees for this flight connection in this database! Contact service");
            }
            System.out.println("Employees Details:");
            System.out.println("------------------------------------------------------------------------------------------------");
            for(Employee emp : employeesList){
                displayEmployeeDetails(emp);
            }
            
        } catch (Exception e) {
            System.out.println("Error Consulting trip crew: " + e.getMessage());
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

    public void displayEmployeeDetails(Employee employee) {

        
        System.out.println("ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Ingress Date: " + employee.getIngressDate());
        System.out.println("Role ID: " + employee.getIdRol());
        System.out.println("User Role ID: " + employee.getIdUserRole());
        System.out.println("Airline ID: " + employee.getIdAirline());
        System.out.println("Airport ID: " + employee.getIdAirport());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("------------------------------------------------------------------------------------------------");
    }


}
