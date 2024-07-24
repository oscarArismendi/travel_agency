package com.o2.travel_agency.customer.infrastructure.in;

import java.util.List;

import com.o2.travel_agency.customer.application.CreateCustomerUseCase;
import com.o2.travel_agency.customer.application.FindCustomerByNroIdcUseCase;
import com.o2.travel_agency.customer.domain.entity.Customer;
import com.o2.travel_agency.documentType.application.ListAllDocumentTypeUseCase;
import com.o2.travel_agency.documentType.domain.entity.DocumentType;
import com.o2.travel_agency.utils.Menus;
import com.o2.travel_agency.utils.MyScanner;

public class CustomerController {

    private FindCustomerByNroIdcUseCase findCustomerByNroIdc;
    private CreateCustomerUseCase createCustomerUseCase;
    private ListAllDocumentTypeUseCase listAllDocumentTypeUseCase;

    public CustomerController(FindCustomerByNroIdcUseCase findCustomerByNroIdc,
            CreateCustomerUseCase createCustomerUseCase, ListAllDocumentTypeUseCase listAllDocumentTypeUseCase) {
        this.findCustomerByNroIdc = findCustomerByNroIdc;
        this.createCustomerUseCase = createCustomerUseCase;
        this.listAllDocumentTypeUseCase = listAllDocumentTypeUseCase;
    }

    public void FindCustomerLogic(){
        try {
            System.out.print("Enter document identification: ");
            Integer nroIdc = MyScanner.scanInt();
            if(nroIdc < 0){
                throw new Exception("The identification can't be negative!");
            }
            if(nroIdc <=  999){
                throw new Exception("The identification must have at least four numbers.");
            }
            Customer customer = findCustomerByNroIdc.execute(nroIdc);
            if(customer == null){
                System.out.println("No customer with the id "+ nroIdc +" had been found.");
            }else{
                displayCustomerDetails(customer);
            }
        } catch (Exception e) {
            System.out.println("Error at finding a customer: " + e.getMessage());
        }
    }

    public void createCustomerLogic(){
        try {
            System.out.print("Enter document identification: ");
            Integer nroIdc = MyScanner.scanInt();
            if(nroIdc < 0){
                throw new Exception("The identification can't be negative!");
            }
            if(nroIdc <=  999){
                throw new Exception("The identification must have at least four numbers.");
            }
            Customer customer = findCustomerByNroIdc.execute(nroIdc);
            if(customer != null){
                throw new Exception("There is already a customer with the document number: " + nroIdc);
            }
            System.out.print("Type the customer first name: ");
            String firstName = MyScanner.scanLine();
            if (firstName.isEmpty()) {
                throw new Exception("You didn't put a first name.");
            }
            System.out.print("Type the customer second name: ");
            String secondName = MyScanner.scanLine();
            if (secondName.isEmpty()) {
                throw new Exception("You didn't put a second name.");
            }
            System.out.print("Type the customer age: ");
            int age = MyScanner.scanInt();
            if(age < 0){
                throw new Exception("The age can't be negative");
            }
            if(age > 120){
                throw new Exception("We doubt that there is someone with " + age + " years");
            }
            // choosin a document type
            List<DocumentType> documentTypesList = listAllDocumentTypeUseCase.execute();
            if (documentTypesList == null) {
                throw new Exception("There are not document in this database!. Contact service.");
            }
            // input a valid flightFare 
            int documentTypePos = Menus.listMenu(documentTypesList,"Choose a document type to see the details:");
            DocumentType userDocumentType = documentTypesList.get(documentTypePos);
            int id = userDocumentType.getId();
            System.out.println("you choose: "+ userDocumentType.toString());
            Customer newCustomer = new Customer(0, firstName, secondName, age, nroIdc, id);
            if(createCustomerUseCase.execute(newCustomer) == null){
                throw new Exception("Couldn't insert the customer in the database.");
            }
        } catch (Exception e) {
            System.out.println("Error at creating a customer: " + e.getMessage());
        }
    }

    public void displayCustomerDetails(Customer customer){
        System.out.println("Customer id: " + customer.getId());
        System.out.println("Customer first name: " + customer.getFirstName());
        System.out.println("Customer last name: " + customer.getLastName());
        System.out.println("Customer age: " + customer.getAge());
        System.out.println("Customer document number: "+ customer.getNroIdc() );
        System.out.println("Customer type of document: "+ customer.getIdDocument());
        System.out.println("------------------------------------------------------------------------------------------------");
    }
}
