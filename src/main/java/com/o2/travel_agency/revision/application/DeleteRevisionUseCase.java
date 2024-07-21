package com.o2.travel_agency.revision.application;

import com.o2.travel_agency.revision.domain.service.RevisionService;

public class DeleteRevisionUseCase {
    private final RevisionService revisionService;

    public DeleteRevisionUseCase(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    public Boolean execute(Integer id) {
        return revisionService.deleteRevision(id);
    }
}
