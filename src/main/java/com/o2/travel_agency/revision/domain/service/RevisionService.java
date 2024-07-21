package com.o2.travel_agency.revision.domain.service;

import java.util.List;

import com.o2.travel_agency.revision.domain.entity.Revision;

public interface RevisionService {
    List<Revision> listAllRevisions();
    Revision createRevision(Revision revision); 
}
