package com.o2.travel_agency.documentType.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.documentType.domain.entity.DocumentType;
import com.o2.travel_agency.documentType.domain.service.DocumentTypeService;
import com.o2.travel_agency.resources.DatabaseConfig;

public class DocumentTypeRepository implements DocumentTypeService {
    @Override
    public List<DocumentType> listAllDocumentTypes() {
        String sql = "SELECT id, name FROM documenttype";
        List<DocumentType> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                DocumentType documentType = new DocumentType(resultSet.getInt("id"), resultSet.getString("name"));
                objects.add(documentType);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

    @Override
    public void RegisterDocument(DocumentType documentType) {
        
    }

    @Override
    public void updateDocumentById(String updateColumns, int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDocumentById'");
    }

    @Override
    public Boolean deleteDocumentTypeById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteDocumentTypeById'");
    }
}
