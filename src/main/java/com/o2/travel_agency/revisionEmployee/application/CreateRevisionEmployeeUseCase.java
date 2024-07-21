package com.o2.travel_agency.revisionEmployee.application;

import com.o2.travel_agency.revisionEmployee.domain.entity.RevisionEmployee;
import com.o2.travel_agency.revisionEmployee.domain.service.RevisionEmployeeService;

public class CreateRevisionEmployeeUseCase {
    private final RevisionEmployeeService revisionEmployeeService;

    public CreateRevisionEmployeeUseCase(RevisionEmployeeService revisionEmployeeService) {
        this.revisionEmployeeService = revisionEmployeeService;
    }

    public RevisionEmployee execute(RevisionEmployee revisionEmployee) {
        return revisionEmployeeService.createRevisionEmployee(revisionEmployee);
    }
}
