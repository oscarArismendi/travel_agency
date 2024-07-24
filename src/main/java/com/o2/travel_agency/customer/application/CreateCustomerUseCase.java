package com.o2.travel_agency.customer.application;

import com.o2.travel_agency.customer.domain.entity.Customer;
import com.o2.travel_agency.customer.domain.service.CustomerService;

public class CreateCustomerUseCase {
    private final CustomerService customerService;

    public CreateCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer execute(Customer customer) {
        return customerService.createCustomer(customer);
    }
}
