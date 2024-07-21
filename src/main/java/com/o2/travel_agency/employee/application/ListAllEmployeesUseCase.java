package com.o2.travel_agency.employee.application;

import java.util.List;

import com.o2.travel_agency.employee.domain.entity.Employee;
import com.o2.travel_agency.employee.domain.service.EmployeeService;

public class ListAllEmployeesUseCase {
    private final EmployeeService employeeService;

    public ListAllEmployeesUseCase(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    public List<Employee> execute(){
        return employeeService.listAllEmployees();
    }
}
