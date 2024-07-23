package com.o2.travel_agency.documentType.domain.service;

import java.util.List;

import com.o2.travel_agency.documentType.domain.entity.DocumentType;

public interface DocumentTypeService {
    List<DocumentType>  listAllDocumentTypes();

    DocumentType RegisterDocument(DocumentType documentType);

    Boolean updateDocumentById(String updateColumns, int id);

    Boolean deleteDocumentTypeById(Integer id);
}

