package com.o2.travel_agency.documentType.application;

import com.o2.travel_agency.documentType.domain.service.DocumentTypeService;

public class DeleteDocumentTypeByIdCase {
    private final DocumentTypeService documentTypeService;

    public  DeleteDocumentTypeByIdCase(DocumentTypeService  documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    public Boolean execute(Integer id) {
        return documentTypeService.deleteDocumentTypeById(id);
    }
}
