package com.o2.travel_agency.documentType.infrastructure.in;


import java.util.List;

import com.o2.travel_agency.documentType.application.DeleteDocumentTypeByIdCase;
import com.o2.travel_agency.documentType.application.ListAllDocumentTypeUseCase;
import com.o2.travel_agency.documentType.application.RegisterDocumentTypeUseCase;
import com.o2.travel_agency.documentType.application.UpdateDocumentTypeByIdUseCase;
import com.o2.travel_agency.documentType.domain.entity.DocumentType;
import com.o2.travel_agency.utils.ConsoleUtils;
import com.o2.travel_agency.utils.Menus;
import com.o2.travel_agency.utils.MyScanner;

public class DocumentTypeController {
     private final RegisterDocumentTypeUseCase registerDocumentTypeUseCase;
    private final UpdateDocumentTypeByIdUseCase updateDocumentTypeByIdUseCase;
    private DeleteDocumentTypeByIdCase deleteDocumentTypeByIdCase;
    private final ListAllDocumentTypeUseCase listAllDocumentTypeUseCase;



    public DocumentTypeController(RegisterDocumentTypeUseCase registerDocumentTypeUseCase,
            UpdateDocumentTypeByIdUseCase updateDocumentTypeByIdUseCase,
            DeleteDocumentTypeByIdCase deleteDocumentTypeByIdCase,
            ListAllDocumentTypeUseCase listAllDocumentTypeUseCase) {
        this.registerDocumentTypeUseCase = registerDocumentTypeUseCase;
        this.updateDocumentTypeByIdUseCase = updateDocumentTypeByIdUseCase;
        this.deleteDocumentTypeByIdCase = deleteDocumentTypeByIdCase;
        this.listAllDocumentTypeUseCase = listAllDocumentTypeUseCase;
    }

    public void start() {
        while (true) {
            displayMenu();

            int option = ConsoleUtils.option_validation("Choose an option: ", 1, 5);
            switch (option) {
                case 1:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------REGISTER DOCUMENTTYPE MENU----------------------------------------");
                    RegisterDocumentTypeLogic();
                    ConsoleUtils.pause();
                    break;
                case 2:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------UPDATE DOCUMENTTYPE MENU----------------------------------------");
                    updateDocumentTypeLogic();
                    ConsoleUtils.pause();
                    break;
                case 3:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------FIND DOCUMENTTYPE MENU----------------------------------------");
                    listAllDocumentTypeLogic();
                    ConsoleUtils.pause();
                    break;
                case 4:
                    ConsoleUtils.cleanScreen();
                    System.out.println("----------------------------------------DELETE DOCUMENTTYPE MENU----------------------------------------");
                    deleteDocumentTypeLogic();
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
        System.out.println("----------------------------------------DOCUMENTTYPE MENU----------------------------------------");
        System.out.println("1. Register DocumentType");
        System.out.println("2. Update DocumentType");
        System.out.println("3. List DocumentType");
        System.out.println("4. Delete DocumentType");
        System.out.println("5. Go back");
    }

    public void deleteDocumentTypeLogic() {
        try {
            System.out.print("Enter DocumentType id to delete: ");
            int id = Integer.parseInt(MyScanner.scanLine());
            deleteDocumentTypeByIdCase.execute(id);
            System.out.println("DocumentType deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error deleting DocumentType: " + e.getMessage());
        }
    }

    public void RegisterDocumentTypeLogic() {
        try {
            System.out.print("Type the DocumentType id: ");
            int id = Integer.parseInt(MyScanner.scanLine());
            System.out.print("Type the DocumentType name: ");
            String name = MyScanner.scanLine();
            if (name.isEmpty()) {
                throw new Exception("You didn't put a name");
            }
            System.out.print("Type the airport city: ");
            Integer idCity = MyScanner.scanInt();
            if (idCity <= 0) {
                throw new Exception("You didn't put a city");
            }

            registerDocumentTypeUseCase.execute(new DocumentType(id, name));
            System.out.println("DocumentType created successfully!");
        } catch (Exception e) {
            System.out.println("Error at creating an airport: " + e.getMessage());
        }
    }

    public void updateDocumentTypeLogic() {
        try {
            System.out.print("Type the airport id: ");
            int id = Integer.parseInt(MyScanner.scanLine());
            List<DocumentType> documentTypeList = listAllDocumentTypeUseCase.execute();
            if (documentTypeList == null) {
                throw new Exception("There is no airport with this id");
            }
            DocumentType userDocumentType = null;
            for (DocumentType documentType : documentTypeList){
                if(documentType.getId() == id){
                    userDocumentType = documentType;
                    break;
                }
            }
            if(userDocumentType == null){
                throw new Exception("There is no document type with this id");
            }
            System.out.println("userDocumentType info: ");
            displayDocumentTypeDetails(userDocumentType);
            int op = Menus.classAttributeMenu(userDocumentType.getClass(), "Choose an attribute to update: ");
            String updateColumns = "";
            switch (op) {
                case 0: // id
                    System.out.print("Type the new airport id (current: " + userDocumentType.getId() + "): ");
                    int newId = Integer.parseInt(MyScanner.scanLine());
                    if (listAllDocumentTypeUseCase.execute() != null) {
                        throw new Exception("There is already an airport with this id");
                    }
                    updateColumns = "id = " + newId;
                    updateDocumentTypeByIdUseCase.execute(updateColumns, userDocumentType.getId());
                    break;
                case 1: // name
                    System.out.print("Type the new airport name (current: " + userDocumentType.getName() + "): ");
                    String newName = MyScanner.scanLine();
                    if (newName.isEmpty()) {
                        throw new Exception("You didn't put a name");
                    }
                    updateColumns = "name = '" + newName + "'";
                    updateDocumentTypeByIdUseCase.execute(updateColumns, userDocumentType.getId());
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error at updating the airport: " + e.getMessage());
        }
    }

    public void listAllDocumentTypeLogic() {
        try {
            System.out.print("Enter documentType id: ");
            int id = MyScanner.scanInt();
            List<DocumentType>  listDocumentType = listAllDocumentTypeUseCase.execute();
            if (listDocumentType == null) {
                throw new Exception("Invalid documentType id.");
            }
            for (DocumentType documentType : listDocumentType){
                if(documentType.getId() == id){
                    displayDocumentTypeDetails(documentType);
                    return;
                }
            }
            System.out.println("There is not document type with the id: " + id);
            
        } catch (Exception e) {
            System.out.println("Error finding airport: " + e.getMessage());
        }
    }

    public void displayDocumentTypeDetails(DocumentType documentType) {
        System.out.println("DocumentType  id: " + documentType.getId());
        System.out.println("DocumentType  name: " + documentType.getName());
        System.out.println("------------------------------------------------------------------------------------------------");
    }

}
