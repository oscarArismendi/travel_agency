package com.o2.travel_agency.customer.domain.service;

import com.o2.travel_agency.customer.domain.entity.Customer;

public interface CustomerService {
    Customer findCustomerByNroIdc(Integer nroIdc);
}
