package com.o2.travel_agency.documentType.infrastructure.in;


import java.util.List;

import com.o2.travel_agency.documentType.application.DeleteDocumentTypeByIdUseCase;
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
    private final DeleteDocumentTypeByIdUseCase deleteDocumentTypeByIdUseCase;
    private final ListAllDocumentTypeUseCase listAllDocumentTypeUseCase;



    public DocumentTypeController(RegisterDocumentTypeUseCase registerDocumentTypeUseCase,
            UpdateDocumentTypeByIdUseCase updateDocumentTypeByIdUseCase,
            DeleteDocumentTypeByIdUseCase deleteDocumentTypeByIdUseCase,
            ListAllDocumentTypeUseCase listAllDocumentTypeUseCase) {
        this.registerDocumentTypeUseCase = registerDocumentTypeUseCase;
        this.updateDocumentTypeByIdUseCase = updateDocumentTypeByIdUseCase;
        this.deleteDocumentTypeByIdUseCase = deleteDocumentTypeByIdUseCase;
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
                    registerDocumentTypeLogic();
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
                    findDocumentTypeByIdLogic();
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
            int id = MyScanner.scanInt();
            List<DocumentType> documentTypeList = listAllDocumentTypeUseCase.execute();
            if (documentTypeList == null) {
                throw new Exception("There aren't documents in this database! Contact service");
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
            int op =  ConsoleUtils.yesOrNo("Are you sure that you want to remove: " + userDocumentType.toString() + " ?");
            if(op == 1){
                if(!deleteDocumentTypeByIdUseCase.execute(id)){
                    throw new Exception("Couldn't find a document type with the id " + id);
                }
            }else{
                System.out.println("You have choose to not remove it.");
            }
        } catch (Exception e) {
            System.out.println("Error deleting DocumentType: " + e.getMessage());
        }
    }

    public void registerDocumentTypeLogic() {
        try {
            System.out.print("Type the DocumentType name: ");
            String name = MyScanner.scanLine();
            if (name.isEmpty()) {
                throw new Exception("You didn't put a name");
            }

            DocumentType documentType = registerDocumentTypeUseCase.execute(new DocumentType(0,name));
            if(documentType == null){
                throw new Exception("There was an error creating the document");
            }
            System.out.println("------------------------------------------------------------------------------------------------");
            displayDocumentTypeDetails(documentType);
            System.out.println("Document type created successfully!");
        } catch (Exception e) {
            System.out.println("Error at creating a document type: " + e.getMessage());
        }
    }

    public void updateDocumentTypeLogic() {
        try {
            List<DocumentType> documentTypeList = listAllDocumentTypeUseCase.execute();
            if (documentTypeList == null) {
                throw new Exception("There aren't documents in this database! Contact service");
            }
            // input a valid document type
            int documentTypePos = Menus.listMenu(documentTypeList,"Choose a document type:");
            DocumentType documentType = documentTypeList.get(documentTypePos);
            int documentTypeId = documentType.getId();
            System.out.println("Document type info: ");
            displayDocumentTypeDetails(documentType);
            int op = Menus.classAttributeMenu(documentType.getClass(), "Choose an attribute to update: ");
            String updateColumns = "";
            switch (op) {
                case 0: // name
                    System.out.print("Type the new document type name (current: " + documentType.getName() + "): ");
                    String newName = MyScanner.scanLine();
                    if (newName.isEmpty()) {
                        throw new Exception("You didn't put a name");
                    }
                    updateColumns = "name = '" + newName + "'";
                    updateDocumentTypeByIdUseCase.execute(updateColumns, documentTypeId);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error at updating the document type: " + e.getMessage());
        }
    }

    public void findDocumentTypeByIdLogic() {
        try {
            System.out.print("Enter documentType id: ");
            int id = MyScanner.scanInt();
            if(id <= 0){
                throw new Exception("There cant be a id that is equal or less than 0");
            }
            List<DocumentType>  listDocumentType = listAllDocumentTypeUseCase.execute();
            if (listDocumentType == null) {
                throw new Exception("The are not document types in the database. Call service.");
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
        System.out.println("Document type  id: " + documentType.getId());
        System.out.println("Document type  name: " + documentType.getName());
        System.out.println("------------------------------------------------------------------------------------------------");
    }

}
