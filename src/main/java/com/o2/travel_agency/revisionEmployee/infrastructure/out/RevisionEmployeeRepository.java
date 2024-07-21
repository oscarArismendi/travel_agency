package com.o2.travel_agency.revisionEmployee.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.o2.travel_agency.resources.DatabaseConfig;
import com.o2.travel_agency.revisionEmployee.domain.entity.RevisionEmployee;
import com.o2.travel_agency.revisionEmployee.domain.service.RevisionEmployeeService;

public class RevisionEmployeeRepository implements RevisionEmployeeService {

    @Override
    public RevisionEmployee createRevisionEmployee(RevisionEmployee revisionEmployee) {
        String sql = "INSERT INTO revemployee (idRevision,idEmployee) VALUES (?,?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, revisionEmployee.getIdRevision());
            statement.setInt(2, revisionEmployee.getIdEmployee());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                // Insert successful, return the provided revisionEmployee object
                return revisionEmployee;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
