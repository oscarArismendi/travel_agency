package com.o2.travel_agency.revisionEmployee.application;

import java.util.List;

import com.o2.travel_agency.revisionEmployee.domain.entity.RevisionEmployee;
import com.o2.travel_agency.revisionEmployee.domain.service.RevisionEmployeeService;

public class ListAllRevisionEmployeeUseCase {
    private final RevisionEmployeeService revisionEmployeeService;

    public ListAllRevisionEmployeeUseCase(RevisionEmployeeService revisionEmployeeService) {
        this.revisionEmployeeService = revisionEmployeeService;
    }

    public List<RevisionEmployee> execute() {
        return revisionEmployeeService.listAllRevisionEmployee();
    }
}
