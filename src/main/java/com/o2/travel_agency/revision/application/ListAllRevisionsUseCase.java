package com.o2.travel_agency.revision.application;

import java.util.List;

import com.o2.travel_agency.revision.domain.entity.Revision;
import com.o2.travel_agency.revision.domain.service.RevisionService;

public class ListAllRevisionsUseCase {
    private final RevisionService revisionService;

    public ListAllRevisionsUseCase(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    public List<Revision> execute(){
        return revisionService.listAllRevisions();
    }
}
