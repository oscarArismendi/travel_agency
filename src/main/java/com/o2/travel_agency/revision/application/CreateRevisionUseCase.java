package com.o2.travel_agency.revision.application;

import com.o2.travel_agency.revision.domain.entity.Revision;
import com.o2.travel_agency.revision.domain.service.RevisionService;

public class CreateRevisionUseCase {
    private final RevisionService revisionService;

    public CreateRevisionUseCase(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    public Revision execute(Revision revision){
        return revisionService.createRevision(revision);
    }
}
