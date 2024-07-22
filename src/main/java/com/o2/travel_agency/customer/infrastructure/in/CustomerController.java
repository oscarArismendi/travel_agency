package com.o2.travel_agency.customer.infrastructure.in;

import com.o2.travel_agency.customer.application.FindCustomerByNroIdcUseCase;
import com.o2.travel_agency.customer.domain.entity.Customer;
import com.o2.travel_agency.utils.MyScanner;

public class CustomerController {

    private FindCustomerByNroIdcUseCase findCustomerByNroIdc;

    public CustomerController(FindCustomerByNroIdcUseCase findCustomerByNroIdc) {
        this.findCustomerByNroIdc = findCustomerByNroIdc;
    }


    public void FindCustomerLogic(){
        try {
            System.out.println("Enter document identification: ");
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
