package com.o2.travel_agency.revisionEmployee.domain.service;

import java.util.List;

import com.o2.travel_agency.revisionEmployee.domain.entity.RevisionEmployee;

public interface RevisionEmployeeService {
    RevisionEmployee createRevisionEmployee(RevisionEmployee revisionEmployee);
    List<RevisionEmployee> listAllRevisionEmployee();
    Boolean updateRevisionEmployeeByRevisionId(String updateColumns, Integer id);
}
