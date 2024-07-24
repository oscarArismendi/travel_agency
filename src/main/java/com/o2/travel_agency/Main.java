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
import com.o2.travel_agency.customer.application.CreateCustomerUseCase;
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
import com.o2.travel_agency.employee.domain.entity.Employee;
import com.o2.travel_agency.employee.domain.service.EmployeeService;
import com.o2.travel_agency.employee.infrastructure.out.EmployeeRepository;
import com.o2.travel_agency.flightconnection.application.ListAllFlightConnectionUseCase;
import com.o2.travel_agency.flightconnection.domain.service.FlightConectionService;
import com.o2.travel_agency.flightconnection.infrastructure.out.FlightConnectionRepository;
import com.o2.travel_agency.flightfare.application.DeleteFlightFareByIdUseCase;
import com.o2.travel_agency.flightfare.application.ListAllFlightFareUseCase;
import com.o2.travel_agency.flightfare.application.RegisterFlightFareUseCase;
import com.o2.travel_agency.flightfare.application.UpdateFlightFareByIdUseCase;
import com.o2.travel_agency.flightfare.domain.service.FlightFareService;
import com.o2.travel_agency.flightfare.infrastructure.in.FlightFareController;
import com.o2.travel_agency.flightfare.infrastructure.out.FlightFareRepository;
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
import com.o2.travel_agency.role_permissions.application.ListAllRolePermissionsUseCase;
import com.o2.travel_agency.role_permissions.domain.entity.RolePermissions;
import com.o2.travel_agency.role_permissions.domain.service.RolePermissionsService;
import com.o2.travel_agency.role_permissions.infrastructure.out.RolePermissionsRepository;
import com.o2.travel_agency.roles.application.ListAllRolesUseCase;
import com.o2.travel_agency.roles.domain.entity.Roles;
import com.o2.travel_agency.roles.domain.service.RolesService;
import com.o2.travel_agency.roles.infrastructure.out.RolesRepository;
import com.o2.travel_agency.status.application.ListAllStatusUseCase;
import com.o2.travel_agency.status.domain.service.StatusService;
import com.o2.travel_agency.status.infrastructure.out.StatusRepository;
import com.o2.travel_agency.trip.application.DeleteTripByIdUseCase;
import com.o2.travel_agency.trip.application.ListAllTripUseCase;
import com.o2.travel_agency.trip.application.UpdateTripByIdUseCase;
import com.o2.travel_agency.trip.domain.service.TripService;
import com.o2.travel_agency.trip.infrastructure.in.TripController;
import com.o2.travel_agency.trip.infrastructure.out.TripRepository;
import com.o2.travel_agency.tripcrew.application.ListAllTripCrewUseCase;
import com.o2.travel_agency.tripcrew.domain.service.TripCrewService;
import com.o2.travel_agency.tripcrew.infrastructure.TripCrewRepository;
import com.o2.travel_agency.utils.ConsoleUtils;
import com.o2.travel_agency.utils.Menus;
import com.o2.travel_agency.utils.MyScanner;

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
        FlightFareService flightFareService = new FlightFareRepository();
        RolesService rolesService  =  new  RolesRepository();
        RolePermissionsService rolePermissionsService  = new RolePermissionsRepository();
        TripService tripService = new TripRepository();
        FlightConectionService flightConectionService = new FlightConnectionRepository();
        TripCrewService tripCrewService =  new TripCrewRepository();
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
        CreateCustomerUseCase createCustomerUseCase = new CreateCustomerUseCase(customerService);
        // Airport use case section
        FindAirportByIdCase findAirportByIdCase = new FindAirportByIdCase(airportService);
        CreateAirportUseCase createAirportUseCase = new CreateAirportUseCase(airportService);
        DeleteAirportByIdCase deleteAirportByIdCase = new DeleteAirportByIdCase(airportService);
        UpdateAirportByIdCase updateAirportByIdCase = new UpdateAirportByIdCase(airportService);
        // country use case section
        ListAllCountriesUseCase listAllCountriesUseCase = new ListAllCountriesUseCase(countryService);
        // city use case section
        ListAllCitiesUseCase listAllCitiesUseCase = new ListAllCitiesUseCase(cityService);
        // flightfare use case section
        DeleteFlightFareByIdUseCase deleteFlightFareByIdUseCase = new DeleteFlightFareByIdUseCase(flightFareService);
        ListAllFlightFareUseCase listAllFlightFareUseCase = new ListAllFlightFareUseCase(flightFareService);
        RegisterFlightFareUseCase registerFlightFareUseCase = new RegisterFlightFareUseCase(flightFareService);
        UpdateFlightFareByIdUseCase updateFlightFareByIdUseCase = new UpdateFlightFareByIdUseCase(flightFareService);
        // user roles  use case  section
        ListAllRolesUseCase listAllRolesUseCase = new ListAllRolesUseCase(rolesService);
        // role_permissions use case section
        ListAllRolePermissionsUseCase  listAllRolePermissionsUseCase =  new ListAllRolePermissionsUseCase(rolePermissionsService);
        // trip use case section
        UpdateTripByIdUseCase updateTripByIdUseCase = new UpdateTripByIdUseCase(tripService);
        DeleteTripByIdUseCase  deleteTripByIdUseCase = new  DeleteTripByIdUseCase(tripService);
        ListAllTripUseCase listAllTripUseCase = new ListAllTripUseCase(tripService);
        // flight connection use  case section
        ListAllFlightConnectionUseCase listAllFlightConnectionUseCase = new ListAllFlightConnectionUseCase(flightConectionService);
        // trip crew use case section
        ListAllTripCrewUseCase listAllTripCrewUseCase = new ListAllTripCrewUseCase(tripCrewService);
        // controller  section
        RevisionController revisionController =  new RevisionController(findPlaneByPlateUseCase, listAllEmployeesUseCase, createRevisionUseCase, createRevisionEmployeeUseCase, listAllRevisionsUseCase, deleteRevisionUseCase, listAllRevisionEmployeeUseCase, updateRevisionByIdUseCase, updateRevisionEmployeeByRevisionIdUseCase);
        PlaneController planeController  = new PlaneController(createPlaneUseCase,listAllAirlinesUseCase,listAllStatusUseCase,listAllModelsUseCase,findPlaneByPlateUseCase,updatePlaneByPlateUseCase,deletePlaneByIdUseCase,listAllRevisionsUseCase);
        CustomerController customerController = new CustomerController(findCustomerByNroIdcUseCase, createCustomerUseCase, listAllDocumentTypeUseCase);
        AirportController airportController = new AirportController(createAirportUseCase, findAirportByIdCase, deleteAirportByIdCase, updateAirportByIdCase, listAllCitiesUseCase, listAllCountriesUseCase);
        DocumentTypeController documentTypeController = new DocumentTypeController(registerDocumentTypeUseCase, updateDocumentTypeByIdUseCase, deleteDocumentTypeByIdCase, listAllDocumentTypeUseCase);
        FlightFareController flightFareController = new FlightFareController(registerFlightFareUseCase, updateFlightFareByIdUseCase, deleteFlightFareByIdUseCase, listAllFlightFareUseCase);
        TripController tripController = new TripController(updateTripByIdUseCase, deleteTripByIdUseCase, listAllTripUseCase, listAllFlightConnectionUseCase, listAllTripCrewUseCase, listAllEmployeesUseCase);
        while(true){
            ConsoleUtils.cleanScreen();
            System.out.println("login as an admin,tech,sales or customer");
            System.out.println("Type your email:");
            String email = MyScanner.scanLine();
            System.out.println("Type  your password:");
            String  password = MyScanner.scanPassword();
            List<Employee>  employees = listAllEmployeesUseCase.execute();
            String nameRol = "";
            int userRolId = 0;
            for(Employee employee : employees){
                if(employee.getEmail().equals(email) && employee.getPassword().equals(password)){
                    List<Roles> listRoles = listAllRolesUseCase.execute();
                    for(Roles  holderRol : listRoles){
                        // System.out.println(holderRol.getId());
                        if(holderRol.getId() == employee.getIdUserRole()){
                            // userRol = holderRol.getName_role();
                            
                            userRolId =  holderRol.getId();
                            nameRol = holderRol.getName_role();
                            break;
                        }
                    }
                }
            }
            ArrayList<Integer> holderAccess = new ArrayList<>();
            List<RolePermissions>  listRolePermissions = listAllRolePermissionsUseCase.execute();
            // System.out.println(userRolId);
            for(RolePermissions rolePermissions : listRolePermissions){
                if(rolePermissions.getRole_id()  == userRolId){
                    holderAccess.add(rolePermissions.getPermissions_id());
                    // System.out.println(rolePermissions.getPermissions_id());
                }
            }
            if(holderAccess.size() ==  0){
                System.out.println("Email or password incorrect.");
                ConsoleUtils.pause();
            }
            // 1,4,5,7,8,10,11,12,15,16,20,21,24,25,30,31,32,33,34,36,35,37
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
            
            Boolean userWantToStay = false;
            if(userPermisions.size() > 1){
                userWantToStay = true;
            }
            while (userWantToStay) {
                ConsoleUtils.cleanScreen();
                String menuChoose = Menus.mainMenu(userPermisions,"------------------------"+ nameRol.toUpperCase() + " MENU--------------------------------------");
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
                        System.out.println("----------------------------------------FIND CUSTOMER MENU------------------------------------------");
                        customerController.FindCustomerLogic();
                        ConsoleUtils.pause();
                        break;
                    case "Register Customer"://7
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------CREATE CUSTOMER MENU----------------------------------------");
                        customerController.createCustomerLogic();
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
                    case "Register Flight Fare"://30
                        ConsoleUtils.cleanScreen();
                        System.out.println("---------------------------------------REGISTER FLIGHT FARE MENU------------------------------------");
                        flightFareController.registerFlightFareLogic();
                        ConsoleUtils.pause();
                        break;
                    case "Update Flight Fare Information"://31
                        ConsoleUtils.cleanScreen();
                        System.out.println("---------------------------------------UPDATE FLIGHT FARE MENU--------------------------------------");
                        flightFareController.updateFlightFareLogic();
                        ConsoleUtils.pause();
                        break;
                    case "Delete Flight Fare"://32
                        ConsoleUtils.cleanScreen();
                        System.out.println("---------------------------------------DELETE FLIGHT FARE MENU--------------------------------------");
                        flightFareController.deleteFlightFareLogic();
                        ConsoleUtils.pause();
                        break;
                    case "Consult Flight Fare":// 33
                        ConsoleUtils.cleanScreen();
                        System.out.println("---------------------------------------CONSULT FLIGHT FARE MENU-------------------------------------");
                        flightFareController.consultFlightFareLogic();
                        ConsoleUtils.pause();
                        break;
                    case "Register Document Type"://34
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------REGISTER DOCUMENT TYPE MENU---------------------------------");
                        documentTypeController.registerDocumentTypeLogic();
                        ConsoleUtils.pause();
                        break;
                    case "Update Document Type": // 35
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------UPDATE DOCUMENT TYPE MENU-----------------------------------");
                        documentTypeController.updateDocumentTypeLogic();
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
                    case "Assign Crew to Route": // 2
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------ASSIGN CREW TO ROUTE MENU------------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Create Flight Reservation": // 3
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------CREATE FLIGHT RESERVATION MENU--------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Consult Flight Reservation": // 6
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------CONSULT FLIGHT RESERVATION MENU--------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Consult Route Information": // 9
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------CONSULT ROUTE INFORMATION MENU--------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "List All Customers": // 22
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------LIST ALL CUSTOMERS MENU----------------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Consult Flight Information": // 23
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------CONSULT FLIGHT INFORMATION MENU--------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Consult Crew Assignment": // 26
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------CONSULT CREW ASSIGNMENT MENU------------------------------------");
                        tripController.ConsultTripLCrewAssingmentLogic();
                        ConsoleUtils.pause();
                        break;
                    case "Consult Route Stops": // 27
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------CONSULT ROUTE STOPS MENU----------------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Update Stop Information": // 28
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------UPDATE STOP INFORMATION MENU------------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Delete Stop": // 29
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------DELETE STOP MENU------------------------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Search Flights": // 38
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------SEARCH FLIGHTS MENU--------------------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Select Flight": // 39
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------SELECT FLIGHT MENU---------------------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Add Passengers": // 40
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------ADD PASSENGERS MENU--------------------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Select Seats": // 41
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------SELECT SEATS MENU----------------------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Make Payment": // 42
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------MAKE PAYMENT MENU---------------------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Cancel Flight Reservation": // 44
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------CANCEL FLIGHT RESERVATION MENU--------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Modify Flight Reservation": // 45
                        ConsoleUtils.cleanScreen();
                        System.out.println("----------------------------------------MODIFY FLIGHT RESERVATION MENU--------------------------------");
                        ConsoleUtils.pause();
                        break;
                    case "Exit":
                        System.out.println("Have a good day!");
                        userWantToStay = false;
                    default:
                        break;
                }
            }
            
            int userWantToLogin =  ConsoleUtils.yesOrNo("Want to try login again?");
            if(userWantToLogin  == 2){
                return;
            }
        }
        
    
    }




}