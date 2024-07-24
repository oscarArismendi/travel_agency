package com.o2.travel_agency.flightconnection.infrastructure.in;

import java.util.List;

import com.o2.travel_agency.flightconnection.application.DeleteFlightConnectionByIdUseCase;
import com.o2.travel_agency.flightconnection.application.ListAllFlightConnectionUseCase;
import com.o2.travel_agency.flightconnection.application.UpdateFlightConnectionByIdUseCase;
import com.o2.travel_agency.flightconnection.domain.entity.FlightConnection;
import com.o2.travel_agency.utils.ConsoleUtils;
import com.o2.travel_agency.utils.Menus;
import com.o2.travel_agency.utils.MyScanner;

public class FlightConnectionController {
    private final ListAllFlightConnectionUseCase  listAllFlightConnectionUseCase;
    private final DeleteFlightConnectionByIdUseCase deleteFlightConnectionByIdUseCase;
    private final UpdateFlightConnectionByIdUseCase updateFlightConnectionByIdUseCase;


    public FlightConnectionController (ListAllFlightConnectionUseCase  listAllFlightConnectionUseCase,
    DeleteFlightConnectionByIdUseCase deleteFlightConnectionByIdUseCase,
    UpdateFlightConnectionByIdUseCase updateFlightConnectionByIdUseCase){
        this.listAllFlightConnectionUseCase = listAllFlightConnectionUseCase;
        this.deleteFlightConnectionByIdUseCase = deleteFlightConnectionByIdUseCase;
        this.updateFlightConnectionByIdUseCase =updateFlightConnectionByIdUseCase;
    }

     public void start() {
        while (true) {
            displayMenu();

            int option = ConsoleUtils.option_validation("Choose an option: ", 1, 5);
            switch (option) {
                case 1:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------UPDATE DOCUMENTTYPE MENU----------------------------------------");
                    updateFlightConnectionLogic();
                    ConsoleUtils.pause();
                    break;
                case 2:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------FIND DOCUMENTTYPE MENU----------------------------------------");
                    findFlightConnectionByIdLogic();
                    ConsoleUtils.pause();
                    break;
                case 3:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------DELETE DOCUMENTTYPE MENU----------------------------------------");
                    deleteFlightConnectionLogic();
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
        System.out.println("----------------------------------------FlightConnection MENU----------------------------------------");
        System.out.println("1. Update FlightConnection");
        System.out.println("2. List FlightConnection");
        System.out.println("3. Delete FlightConnection");
        System.out.println("4. Go back");
    }

    public void deleteFlightConnectionLogic() {
        try {
            System.out.print("Enter Flight Connection id to delete: ");
            int id = MyScanner.scanInt();
            List<FlightConnection> flightConnectionList = listAllFlightConnectionUseCase.execute();
            if (flightConnectionList == null) {
                throw new Exception("There aren't any flight connections in this database! Contact service");
            }
            FlightConnection userFlightConnection = null;
            for (FlightConnection flightConnection : flightConnectionList) {
                if (flightConnection.getId() == id) {
                    userFlightConnection = flightConnection;
                    break;
                }
            }
            if (userFlightConnection == null) {
                throw new Exception("There is no flight connection with this id");
            }
            int op = ConsoleUtils.yesOrNo("Are you sure that you want to remove: " + userFlightConnection.toString() + " ?");
            if (op == 1) {
                if (!deleteFlightConnectionByIdUseCase.execute(id)) {
                    throw new Exception("Couldn't find a flight connection with the id " + id);
                }
            } else {
                System.out.println("You have chosen not to remove it.");
            }
        } catch (Exception e) {
            System.out.println("Error deleting Flight Connection: " + e.getMessage());
        }
    }
    public void updateFlightConnectionLogic() {
        try {
            List<FlightConnection> flightConnectionList = listAllFlightConnectionUseCase.execute();
            if (flightConnectionList == null) {
                throw new Exception("There aren't any flight connections in this database! Contact service");
            }
            // input a valid flight connection
            int flightConnectionPos = Menus.listMenu(flightConnectionList, "Choose a flight connection:");
            FlightConnection flightConnection = flightConnectionList.get(flightConnectionPos);
            int flightConnectionId = flightConnection.getId();
            System.out.println("Flight Connection info: ");
            displayFlightConnectionDetails(flightConnection);
            int op = Menus.classAttributeMenu(flightConnection.getClass(), "Choose an attribute to update: ");
            String updateColumns = "";
            switch (op) {
                case 0: // connectionNumber
                    System.out.print("Type the new connection number (current: " + flightConnection.getConnectionNumber() + "): ");
                    String newConnectionNumber = MyScanner.scanLine();
                    if (newConnectionNumber.isEmpty()) {
                        throw new Exception("You didn't put a connection number");
                    }
                    updateColumns = "connectionNumber = '" + newConnectionNumber + "'";
                    updateFlightConnectionByIdUseCase.execute(updateColumns, flightConnectionId);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error updating the flight connection: " + e.getMessage());
        }
    }

    public void findFlightConnectionByIdLogic() {
        try {
            List<FlightConnection> flightConnectionList = listAllFlightConnectionUseCase.execute();
            if (flightConnectionList == null) {
                throw new Exception("There are no flight connections in the database. Contact service.");
            }
            for (FlightConnection flightConnection : flightConnectionList) {
                displayFlightConnectionDetails(flightConnection);
            }
        } catch (Exception e) {
            System.out.println("Error listing flight connections: " + e.getMessage());
        }
    }

    public void displayFlightConnectionDetails(FlightConnection flightConnection) {
        System.out.println("Flight Connection id: " + flightConnection.getId());
        System.out.println("Flight Connection number: " + flightConnection.getConnectionNumber());
        System.out.println("Trip id: " + flightConnection.getIdTrip());
        System.out.println("Plane id: " + flightConnection.getIdPlane());
        System.out.println("Airport id: " + flightConnection.getIdAirport());
        System.out.println("------------------------------------------------------------------------------------------------");
    }
}