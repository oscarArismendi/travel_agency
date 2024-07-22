package com.o2.travel_agency.airport.infrastructure.in;

import com.o2.travel_agency.airport.application.CreateAirportUseCase;
import com.o2.travel_agency.airport.application.DeleteAirportByIdCase;
import com.o2.travel_agency.airport.application.FindAirportByIdCase;
import com.o2.travel_agency.airport.application.UpdateAirportByIdCase;
import com.o2.travel_agency.airport.domain.entity.Airport;
import com.o2.travel_agency.utils.ConsoleUtils;
import com.o2.travel_agency.utils.Menus;
import com.o2.travel_agency.utils.MyScanner;

public class AirportController {

    private final CreateAirportUseCase createAirportUseCase;
    private final FindAirportByIdCase findAirportByIdUseCase;
    private final DeleteAirportByIdCase deleteAirportByIdUseCase;
    private Integer idcity;

    public AirportController(CreateAirportUseCase createAirportUseCase,
                             FindAirportByIdCase findAirportByIdUseCase, 
                             UpdateAirportByIdCase updateAirportByIdUseCase,
                             DeleteAirportByIdCase deleteAirportByIdUseCase) {
        this.createAirportUseCase = createAirportUseCase;
        this.findAirportByIdUseCase = findAirportByIdUseCase;
        this.deleteAirportByIdUseCase = deleteAirportByIdUseCase;
    }

    public void start() {
        while (true) {
            displayMenu();

            int option = ConsoleUtils.option_validation("Choose an option: ", 1, 5);
            switch (option) {
                case 1:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------CREATE AIRPORT MENU----------------------------------------");
                    createAirportLogic();
                    ConsoleUtils.pause();
                    break;
                case 2:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------UPDATE AIRPORT MENU----------------------------------------");
                    updateAirportLogic();
                    ConsoleUtils.pause();
                    break;
                case 3:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------FIND AIRPORT MENU----------------------------------------");
                    findAirportLogic();
                    ConsoleUtils.pause();
                    break;
                case 4:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------DELETE AIRPORT MENU----------------------------------------");
                    deleteAirportLogic();
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
        System.out.println("----------------------------------------AIRPORT MENU----------------------------------------");
        System.out.println("1. Create Airport");
        System.out.println("2. Update Airport");
        System.out.println("3. Find Airport");
        System.out.println("4. Delete Airport");
        System.out.println("5. Go back");
    }

    private void deleteAirportLogic() {
        try {
            System.out.print("Enter airport id to delete: ");
            int id = Integer.parseInt(MyScanner.scanLine());
            deleteAirportByIdUseCase.execute(id);
            System.out.println("Airport deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error deleting airport: " + e.getMessage());
        }
    }

    public void createAirportLogic() {
        try {
            System.out.print("Type the airport id: ");
            int id = Integer.parseInt(MyScanner.scanLine());
            System.out.print("Type the airport name: ");
            String name = MyScanner.scanLine();
            if (name.isEmpty()) {
                throw new Exception("You didn't put a name");
            }
            System.out.print("Type the airport city: ");
            String city = MyScanner.scanLine();
            if (city.isEmpty()) {
                throw new Exception("You didn't put a city");
            }
            System.out.print("Type the airport country: ");
            String country = MyScanner.scanLine();
            if (country.isEmpty()) {
                throw new Exception("You didn't put a country");
            }

            createAirportUseCase.execute(new Airport(id, name, idcity));
            System.out.println("Airport created successfully!");
        } catch (Exception e) {
            System.out.println("Error at creating an airport: " + e.getMessage());
        }
    }

    public void updateAirportLogic() {
        try {
            System.out.print("Type the airport id: ");
            int id = Integer.parseInt(MyScanner.scanLine());
            Airport airport = findAirportByIdUseCase.execute(id);
            if (airport == null) {
                throw new Exception("There is no airport with this id");
            }
            System.out.println("Airport info: ");
            displayAirportDetails(airport);
            int op = Menus.classAttributeMenu(airport.getClass(), "Choose an attribute to update: ");
            String updateColumns = "";
            switch (op) {
                case 0: // id
                    System.out.print("Type the new airport id (current: " + airport.getId() + "): ");
                    int newId = Integer.parseInt(MyScanner.scanLine());
                    if (findAirportByIdUseCase.execute(newId) != null) {
                        throw new Exception("There is already an airport with this id");
                    }
                    updateColumns = "id = " + newId;
                    UpdateAirportByIdCase.execute(updateColumns, airport.getId());
                    break;
                case 1: // name
                    System.out.print("Type the new airport name (current: " + airport.getName() + "): ");
                    String newName = MyScanner.scanLine();
                    if (newName.isEmpty()) {
                        throw new Exception("You didn't put a name");
                    }
                    updateColumns = "name = '" + newName + "'";
                    UpdateAirportByIdCase.execute(updateColumns, airport.getId());
                    break;
                case 2: // city
                    System.out.print("Type the new airport city (current: " + airport.getCity() + "): ");
                    String newCity = MyScanner.scanLine();
                    if (newCity.isEmpty()) {
                        throw new Exception("You didn't put a city");
                    }
                    updateColumns = "city = '" + newCity + "'";
                    UpdateAirportByIdCase.execute(updateColumns, airport.getId());
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error at updating the airport: " + e.getMessage());
        }
    }

    public void findAirportLogic() {
        try {
            System.out.print("Enter airport id: ");
            int id = Integer.parseInt(MyScanner.scanLine());
            Airport airport = findAirportByIdUseCase.execute(id);
            if (airport == null) {
                throw new Exception("Invalid airport id.");
            }
            displayAirportDetails(airport);
        } catch (Exception e) {
            System.out.println("Error finding airport: " + e.getMessage());
        }
    }

    public void displayAirportDetails(Airport airport) {
        System.out.println("Airport id: " + airport.getId());
        System.out.println("Airport name: " + airport.getName());
        System.out.println("Airport city: " + airport.getCity());
        System.out.println("------------------------------------------------------------------------------------------------");
    }
}
