package com.o2.travel_agency.revision.application;

import com.o2.travel_agency.revision.domain.service.RevisionService;

public class UpdateRevisionByIdUseCase {
    private final RevisionService revisionService;

    public UpdateRevisionByIdUseCase(RevisionService revisionService) {
        this.revisionService = revisionService;
    }
    
    public Boolean execute(String updateColumns, Integer id){
        return revisionService.updateRevisionById(updateColumns, id);
    }
}
