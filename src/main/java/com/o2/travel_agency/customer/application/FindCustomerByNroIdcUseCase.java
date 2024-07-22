package com.o2.travel_agency.customer.application;

import com.o2.travel_agency.customer.domain.entity.Customer;
import com.o2.travel_agency.customer.domain.service.CustomerService;

public class FindCustomerByNroIdcUseCase {
    private final CustomerService customerService;

    public FindCustomerByNroIdcUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer execute(Integer nroIdc) {
        return customerService.findCustomerByNroIdc(nroIdc);
    }
}
