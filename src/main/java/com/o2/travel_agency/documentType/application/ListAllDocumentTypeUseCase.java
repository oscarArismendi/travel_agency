package com.o2.travel_agency.documentType.application;

import java.util.List;

import com.o2.travel_agency.documentType.domain.entity.DocumentType;
import com.o2.travel_agency.documentType.domain.service.DocumentTypeService;

public class ListAllDocumentTypeUseCase {
    private final DocumentTypeService documentTypeService;

    public ListAllDocumentTypeUseCase(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }
    
    public  List<DocumentType> execute(){
        return documentTypeService.listAllDocumentTypes();
    }
}
