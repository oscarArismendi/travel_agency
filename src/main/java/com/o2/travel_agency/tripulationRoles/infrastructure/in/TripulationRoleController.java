package com.o2.travel_agency.tripulationRoles.infrastructure.in;

import java.util.List;

import com.o2.travel_agency.tripulationRoles.application.ListAllTripulationRoleUseCase;
import com.o2.travel_agency.tripulationRoles.domain.entity.TripulationRole;
import com.o2.travel_agency.utils.ConsoleUtils;
import com.o2.travel_agency.utils.MyScanner;

public class TripulationRoleController {
    private final ListAllTripulationRoleUseCase listAllTripulationRoleUseCase;

    public TripulationRoleController (ListAllTripulationRoleUseCase listAllTripulationRoleUseCase){
        this.listAllTripulationRoleUseCase = listAllTripulationRoleUseCase;
    }

     public void start() {
        while (true) {
            displayMenu();

            int option = ConsoleUtils.option_validation("Choose an option: ", 1, 5);
            switch (option) {
                
                case 3:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------FIND DOCUMENTTYPE MENU----------------------------------------");
                    listAllTripulationRoleLogic();
                    ConsoleUtils.pause();
                    break;
                
            }
        }
    }

    private void displayMenu() {
        System.out.println("----------------------------------------DOCUMENTTYPE MENU----------------------------------------");
        System.out.println("1. List DocumentType");
        System.out.println("2. Go back");
    }

    private void listAllTripulationRoleLogic() {
        try {
            System.out.print("Enter tripulationrole id: ");
            int id = MyScanner.scanInt();
            List<TripulationRole>  listTripulationRole = listAllTripulationRoleUseCase.execute();
            if (listTripulationRole == null) {
                throw new Exception("Invalid tripulationrole id.");
            }
            for (TripulationRole tripulationRole : listTripulationRole){
                if(tripulationRole.getId() == id){
                    displayTripulationRoleDetails(tripulationRole);
                    return;
                }
            }
            System.out.println("There is not tripulation role with the id: " + id);
            
        } catch (Exception e) {
            System.out.println("Error finding airport: " + e.getMessage());
        }
    }

    private void displayTripulationRoleDetails(TripulationRole tripulationRole) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayTripulationRoleDetails'");
    }

}
