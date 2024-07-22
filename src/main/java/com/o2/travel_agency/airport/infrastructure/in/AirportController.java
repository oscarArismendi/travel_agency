package com.o2.travel_agency.airport.infrastructure.in;

import java.util.List;

import com.o2.travel_agency.airport.application.CreateAirportUseCase;
import com.o2.travel_agency.airport.application.DeleteAirportByIdCase;
import com.o2.travel_agency.airport.application.FindAirportByIdCase;
import com.o2.travel_agency.airport.application.UpdateAirportByIdCase;
import com.o2.travel_agency.airport.domain.entity.Airport;
import com.o2.travel_agency.city.application.ListAllCitiesUseCase;
import com.o2.travel_agency.city.domain.entity.City;
import com.o2.travel_agency.country.application.ListAllCountriesUseCase;
import com.o2.travel_agency.country.domain.entity.Country;
import com.o2.travel_agency.utils.ConsoleUtils;
import com.o2.travel_agency.utils.Menus;
import com.o2.travel_agency.utils.MyScanner;

public class AirportController {

    private final CreateAirportUseCase createAirportUseCase;
    private final FindAirportByIdCase findAirportByIdUseCase;
    private final DeleteAirportByIdCase deleteAirportByIdUseCase;
    private final UpdateAirportByIdCase updateAirportByIdUseCase;
    private final ListAllCitiesUseCase listAllCitiesUseCase;
    private final ListAllCountriesUseCase listAllCountriesUseCase;



    public AirportController(CreateAirportUseCase createAirportUseCase, FindAirportByIdCase findAirportByIdUseCase,
            DeleteAirportByIdCase deleteAirportByIdUseCase, UpdateAirportByIdCase updateAirportByIdUseCase,
            ListAllCitiesUseCase listAllCitiesUseCase, ListAllCountriesUseCase listAllCountriesUseCase) {
        this.createAirportUseCase = createAirportUseCase;
        this.findAirportByIdUseCase = findAirportByIdUseCase;
        this.deleteAirportByIdUseCase = deleteAirportByIdUseCase;
        this.updateAirportByIdUseCase = updateAirportByIdUseCase;
        this.listAllCitiesUseCase = listAllCitiesUseCase;
        this.listAllCountriesUseCase = listAllCountriesUseCase;
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
            int id = MyScanner.scanInt();
            if(findAirportByIdUseCase.execute(id) != null){
                throw new Exception("There is already a airport with this id");
            }
            if(id <= 0){
                throw new Exception("The id must be greater than 0");
            }
            System.out.print("Type the airport name: ");
            String name = MyScanner.scanLine();
            if (name.isEmpty()) {
                throw new Exception("You didn't put a name");
            }
            // Countries show all countries, return a list
            List<Country> countries =  listAllCountriesUseCase.execute();
            if(countries.size() ==  0){
                throw new Exception("There are not countries in the database! contact service.");
            }
            //  input a valid country
            int countryPos =  Menus.listMenu(countries,"Choose a country:");
            Country country = countries.get(countryPos);
            int countryId = country.getId();

            // Cities show all cities, return a list
            List<City> cities =  listAllCitiesUseCase.execute();
            if(cities.size() ==  0){
                throw new Exception("There are not cities in the database! contact service.");
            }

            cities.removeIf(obj -> obj.getIdCountry() != countryId);
            if(cities.size() ==  0){
                throw new Exception("There are not cities related to "+ country.toString() + " in the database! contact service.");
            }
            //  input a valid city
            int cityPos =  Menus.listMenu(cities,"Choose a city:");
            int cityId = cities.get(cityPos).getId();

            createAirportUseCase.execute(new Airport(id, name, cityId));
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
                    updateAirportByIdUseCase.execute(updateColumns, airport.getId());
                    break;
                case 1: // name
                    System.out.print("Type the new airport name (current: " + airport.getName() + "): ");
                    String newName = MyScanner.scanLine();
                    if (newName.isEmpty()) {
                        throw new Exception("You didn't put a name");
                    }
                    updateColumns = "name = '" + newName + "'";
                    updateAirportByIdUseCase.execute(updateColumns, airport.getId());
                    break;
                case 2: // city
                    System.out.print("Type the new airport city (current: " + airport.getIdCity() + "): ");
                    String newCity = MyScanner.scanLine();
                    if (newCity.isEmpty()) {
                        throw new Exception("You didn't put a city");
                    }
                    updateColumns = "city = '" + newCity + "'";
                    updateAirportByIdUseCase.execute(updateColumns, airport.getId());
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error at updating the airport: " + e.getMessage());
        }
    }

    public void findAirportLogic() {
        try {
            System.out.print("Enter airport id: ");
            int id = MyScanner.scanInt();
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
        System.out.println("Airport city: " + airport.getIdCity());
        System.out.println("------------------------------------------------------------------------------------------------");
    }
}
