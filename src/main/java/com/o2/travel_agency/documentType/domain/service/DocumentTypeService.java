package com.o2.travel_agency.documentType.domain.service;

import java.util.List;

import com.o2.travel_agency.documentType.domain.entity.DocumentType;

public interface DocumentTypeService {
    List<DocumentType>  listAllDocumentTypes();

    void RegisterDocument(DocumentType documentType);

    void updateDocumentById(String updateColumns, int id);

    Boolean deleteDocumentTypeById(Integer id);
}

