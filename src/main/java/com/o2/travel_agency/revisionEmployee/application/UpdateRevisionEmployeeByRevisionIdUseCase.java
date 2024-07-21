package com.o2.travel_agency.revisionEmployee.application;

import com.o2.travel_agency.revisionEmployee.domain.service.RevisionEmployeeService;

public class UpdateRevisionEmployeeByRevisionIdUseCase {
    private final RevisionEmployeeService revisionEmployeeService;

    public UpdateRevisionEmployeeByRevisionIdUseCase(RevisionEmployeeService revisionEmployeeService) {
        this.revisionEmployeeService = revisionEmployeeService;
    }

    public Boolean execute(String updateColumns, Integer id){
        return revisionEmployeeService.updateRevisionEmployeeByRevisionId(updateColumns, id);
    }
}
