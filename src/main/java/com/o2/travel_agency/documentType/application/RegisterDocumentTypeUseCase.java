package com.o2.travel_agency.documentType.application;

import com.o2.travel_agency.documentType.domain.entity.DocumentType;
import com.o2.travel_agency.documentType.domain.service.DocumentTypeService;

public class RegisterDocumentTypeUseCase {
    private final DocumentTypeService documentTypeService;

    public RegisterDocumentTypeUseCase(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

   public DocumentType execute(DocumentType documentType) {
        return documentTypeService.RegisterDocument(documentType);
    }
}
