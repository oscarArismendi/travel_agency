package com.o2.travel_agency.documentType.application;

 
import com.o2.travel_agency.documentType.domain.service.DocumentTypeService;

public class UpdateDocumentTypeByIdUseCase {
    private final DocumentTypeService documentTypeService;

    public UpdateDocumentTypeByIdUseCase (DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    public Boolean execute(String updateColumns, Integer id) {
        documentTypeService.updateDocumentById(updateColumns, id);
        return null;
    }
}
