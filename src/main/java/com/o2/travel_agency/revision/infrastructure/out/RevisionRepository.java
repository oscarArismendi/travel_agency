package com.o2.travel_agency.revision.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.resources.DatabaseConfig;
import com.o2.travel_agency.revision.domain.entity.Revision;
import com.o2.travel_agency.revision.domain.service.RevisionService;

public class RevisionRepository implements RevisionService {
    @Override
    public List<Revision> listAllRevisions() {
        String sql = "SELECT id, revisionDate,idPlane,description FROM revision";
        List<Revision> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Revision revision = new Revision(resultSet.getInt("id"), resultSet.getDate("revisionDate"),
                        resultSet.getInt("idPlane"), resultSet.getString("description"));
                objects.add(revision);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
