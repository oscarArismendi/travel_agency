package com.o2.travel_agency.status.application;

import java.util.List;

import com.o2.travel_agency.status.domain.entity.Status;
import com.o2.travel_agency.status.service.StatusService;

public class ListAllStatusUseCase {
    private final StatusService statusService;

    public ListAllStatusUseCase(StatusService statusService) {
        this.statusService = statusService;
    }

    public List<Status> execute() {
        return statusService.listAllStatus();
    }
}
