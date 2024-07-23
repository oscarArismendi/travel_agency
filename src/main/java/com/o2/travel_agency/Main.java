package com.o2.travel_agency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.o2.travel_agency.airline.application.ListAllAirlinesUseCase;
import com.o2.travel_agency.airline.domain.service.AirlineService;
import com.o2.travel_agency.airline.infrastructure.out.AirlineRepository;
import com.o2.travel_agency.airport.application.CreateAirportUseCase;
import com.o2.travel_agency.airport.application.DeleteAirportByIdCase;
import com.o2.travel_agency.airport.application.FindAirportByIdCase;
import com.o2.travel_agency.airport.application.UpdateAirportByIdCase;
import com.o2.travel_agency.airport.domain.service.AirportService;
import com.o2.travel_agency.airport.infrastructure.in.AirportController;
import com.o2.travel_agency.airport.infrastructure.out.AirportRepository;
import com.o2.travel_agency.city.application.ListAllCitiesUseCase;
import com.o2.travel_agency.city.domain.service.CityService;
import com.o2.travel_agency.city.infrastructure.out.CityRepository;
import com.o2.travel_agency.country.application.ListAllCountriesUseCase;
import com.o2.travel_agency.country.domain.service.CountryService;
import com.o2.travel_agency.country.infrastructure.out.CountryRepository;
import com.o2.travel_agency.customer.application.FindCustomerByNroIdcUseCase;
import com.o2.travel_agency.customer.domain.service.CustomerService;
import com.o2.travel_agency.customer.infrastructure.in.CustomerController;
import com.o2.travel_agency.customer.infrastructure.out.CustomerRepository;
import com.o2.travel_agency.documentType.application.DeleteDocumentTypeByIdUseCase;
import com.o2.travel_agency.documentType.application.ListAllDocumentTypeUseCase;
import com.o2.travel_agency.documentType.application.RegisterDocumentTypeUseCase;
import com.o2.travel_agency.documentType.application.UpdateDocumentTypeByIdUseCase;
import com.o2.travel_agency.documentType.domain.service.DocumentTypeService;
import com.o2.travel_agency.documentType.infrastructure.in.DocumentTypeController;
import com.o2.travel_agency.documentType.infrastructure.out.DocumentTypeRepository;
import com.o2.travel_agency.employee.application.ListAllEmployeesUseCase;
import com.o2.travel_agency.employee.domain.service.EmployeeService;
import com.o2.travel_agency.employee.infrastructure.out.EmployeeRepository;
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
import com.o2.travel_agency.revision.application.CreateRevisionUseCase;
import com.o2.travel_agency.revision.application.DeleteRevisionUseCase;
import com.o2.travel_agency.revision.application.ListAllRevisionsUseCase;
import com.o2.travel_agency.revision.application.UpdateRevisionByIdUseCase;
import com.o2.travel_agency.revision.domain.service.RevisionService;
import com.o2.travel_agency.revision.infrastructure.in.RevisionController;
import com.o2.travel_agency.revision.infrastructure.out.RevisionRepository;
import com.o2.travel_agency.revisionEmployee.application.CreateRevisionEmployeeUseCase;
import com.o2.travel_agency.revisionEmployee.application.ListAllRevisionEmployeeUseCase;
import com.o2.travel_agency.revisionEmployee.application.UpdateRevisionEmployeeByRevisionIdUseCase;
import com.o2.travel_agency.revisionEmployee.domain.service.RevisionEmployeeService;
import com.o2.travel_agency.revisionEmployee.infrastructure.out.RevisionEmployeeRepository;
import com.o2.travel_agency.status.application.ListAllStatusUseCase;
import com.o2.travel_agency.status.domain.service.StatusService;
import com.o2.travel_agency.status.infrastructure.out.StatusRepository;
import com.o2.travel_agency.utils.ConsoleUtils;
import com.o2.travel_agency.utils.Menus;

public class Main {
    public static void main(String[] args) {
        //Service declaration
        AirlineService airlineService = new AirlineRepository();
        StatusService statusService = new StatusRepository();
        ModelService modelService = new ModelRepository();
        EmployeeService  employeeService = new  EmployeeRepository();
        RevisionEmployeeService revisionEmployeeService = new RevisionEmployeeRepository();
        RevisionService revisionService = new RevisionRepository();
        PlaneService planeService = new PlaneRepository();
        DocumentTypeService documentTypeService = new DocumentTypeRepository();
        CustomerService customerService = new CustomerRepository();
        AirportService airportService = new AirportRepository();
        CityService cityService = new CityRepository();
        CountryService countryService = new CountryRepository();
        //airline use case setion
        ListAllAirlinesUseCase listAllAirlinesUseCase = new ListAllAirlinesUseCase(airlineService);

        // status use case section
        ListAllStatusUseCase listAllStatusUseCase = new ListAllStatusUseCase(statusService);

        // model use case section
        ListAllModelsUseCase listAllModelsUseCase = new ListAllModelsUseCase(modelService);
        
        //Employee use case section

        ListAllEmployeesUseCase listAllEmployeesUseCase = new ListAllEmployeesUseCase(employeeService);
        
        //RevisionEmployee use case section

        CreateRevisionEmployeeUseCase createRevisionEmployeeUseCase = new CreateRevisionEmployeeUseCase(revisionEmployeeService);
        ListAllRevisionEmployeeUseCase listAllRevisionEmployeeUseCase = new ListAllRevisionEmployeeUseCase(revisionEmployeeService);
        // revision use case section
        ListAllRevisionsUseCase listAllRevisionsUseCase = new ListAllRevisionsUseCase(revisionService);
        CreateRevisionUseCase createRevisionUseCase = new  CreateRevisionUseCase(revisionService);
        DeleteRevisionUseCase deleteRevisionUseCase = new DeleteRevisionUseCase(revisionService);
        UpdateRevisionByIdUseCase updateRevisionByIdUseCase = new UpdateRevisionByIdUseCase(revisionService);
        UpdateRevisionEmployeeByRevisionIdUseCase updateRevisionEmployeeByRevisionIdUseCase = new UpdateRevisionEmployeeByRevisionIdUseCase(revisionEmployeeService);
        // plane use case section
        CreatePlaneUseCase createPlaneUseCase = new  CreatePlaneUseCase(planeService);
        FindPlaneByPlateUseCase findPlaneByPlateUseCase = new FindPlaneByPlateUseCase(planeService);
        UpdatePlaneByPlateUseCase updatePlaneByPlateUseCase = new UpdatePlaneByPlateUseCase(planeService);
        DeletePlaneByIdUseCase  deletePlaneByIdUseCase = new DeletePlaneByIdUseCase(planeService);
        // document type use case section
        ListAllDocumentTypeUseCase listAllDocumentTypeUseCase = new ListAllDocumentTypeUseCase(documentTypeService);
        RegisterDocumentTypeUseCase registerDocumentTypeUseCase = new RegisterDocumentTypeUseCase(documentTypeService);
        UpdateDocumentTypeByIdUseCase updateDocumentTypeByIdUseCase = new UpdateDocumentTypeByIdUseCase(documentTypeService);
        DeleteDocumentTypeByIdUseCase deleteDocumentTypeByIdCase = new DeleteDocumentTypeByIdUseCase(documentTypeService);
        // Customer use case section
        FindCustomerByNroIdcUseCase findCustomerByNroIdcUseCase = new FindCustomerByNroIdcUseCase(customerService);
        // Airport use case section
        FindAirportByIdCase findAirportByIdCase = new FindAirportByIdCase(airportService);
        CreateAirportUseCase createAirportUseCase = new CreateAirportUseCase(airportService);
        DeleteAirportByIdCase deleteAirportByIdCase = new DeleteAirportByIdCase(airportService);
        UpdateAirportByIdCase updateAirportByIdCase = new UpdateAirportByIdCase(airportService);
        // country use case section
        ListAllCountriesUseCase listAllCountriesUseCase = new ListAllCountriesUseCase(countryService);
        // city use case section
        ListAllCitiesUseCase listAllCitiesUseCase = new ListAllCitiesUseCase(cityService);
        // controller  section
        RevisionController revisionController =  new RevisionController(findPlaneByPlateUseCase, listAllEmployeesUseCase, createRevisionUseCase, createRevisionEmployeeUseCase, listAllRevisionsUseCase, deleteRevisionUseCase, listAllRevisionEmployeeUseCase, updateRevisionByIdUseCase, updateRevisionEmployeeByRevisionIdUseCase);
        PlaneController planeController  = new PlaneController(createPlaneUseCase,listAllAirlinesUseCase,listAllStatusUseCase,listAllModelsUseCase,findPlaneByPlateUseCase,updatePlaneByPlateUseCase,deletePlaneByIdUseCase,listAllRevisionsUseCase);
        CustomerController customerController = new CustomerController(findCustomerByNroIdcUseCase);
        AirportController airportController = new AirportController(createAirportUseCase, findAirportByIdCase, deleteAirportByIdCase, updateAirportByIdCase, listAllCitiesUseCase, listAllCountriesUseCase);
        DocumentTypeController documentTypeController = new DocumentTypeController(registerDocumentTypeUseCase, updateDocumentTypeByIdUseCase, deleteDocumentTypeByIdCase, listAllDocumentTypeUseCase);

        String userRol = "ADMIN";
        int[] holderAccess = {1,4,5,8,10,11,12,15,16,20,21,24,25,34,36,37};
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
            "List All Customers",  // 22
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
                case "Register Maintenance Review"://4
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------CREATE MAINTENANCE MENU-------------------------------------");
                    revisionController.createRevisionLogic();
                    ConsoleUtils.pause();
                    break;
                case "Consult Customer Information"://5
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------CREATE CUSTOMER MENU----------------------------------------");
                    customerController.FindCustomerLogic();
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
                    airportController.createAirportLogic();
                    ConsoleUtils.pause();
                    break;
                case "Consult Airport Information"://11
                    ConsoleUtils.cleanScreen();
                    System.out.println("-------------------------------------------FIND AIRPORT MENU----------------------------------------");
                    airportController.findAirportLogic();
                    ConsoleUtils.pause();
                    break;
                case "Consult Plane Maintenance History"://12
                    ConsoleUtils.cleanScreen();
                    System.out.println("---------------------------------------PLANE MAINTENANCE HISTORY MENU-------------------------------");
                    planeController.maintenanceHistoryLogic();
                    ConsoleUtils.pause();
                    break;
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
                    airportController.updateAirportLogic();
                    ConsoleUtils.pause();
                    break;
                case "Delete Airport"://21
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------DELETE AIRPORT MENU-----------------------------------------");
                    airportController.deleteAirportLogic();
                    ConsoleUtils.pause();
                    break;
                case "Update Maintenance Review Information"://24
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------UPDATE MAINTENANCE MENU-----------------------------------------");
                    revisionController.updateRevisionLogic();
                    ConsoleUtils.pause();
                    break;
                case "Delete Maintenance Review"://25
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------DELETE MAINTENANCE MENU-------------------------------------");
                    revisionController.deletedRevisionLogic();
                    ConsoleUtils.pause();
                    break;
                case "Register Document Type"://34
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------REGISTER MAINTENANCE MENU-------------------------------------");
                    documentTypeController.registerDocumentTypeLogic();
                    ConsoleUtils.pause();
                    break;
                case "Delete Document Type": //36
                    ConsoleUtils.cleanScreen();
                    System.out.println("--------------------------------------DELETE DOCUMENT TYPE MENU-------------------------------------");
                    documentTypeController.deleteDocumentTypeLogic();
                    ConsoleUtils.pause();
                    break;
                case "Consult Document Type"://37
                    ConsoleUtils.cleanScreen();
                    System.out.println("--------------------------------------CONSULT DOCUMENT TYPE MENU------------------------------------");
                    documentTypeController.findDocumentTypeByIdLogic();
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