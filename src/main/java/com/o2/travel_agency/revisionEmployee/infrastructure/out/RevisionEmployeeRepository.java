package com.o2.travel_agency.revisionEmployee.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<RevisionEmployee> listAllRevisionEmployee(){
        String sql = "SELECT idRevision, idEmployee FROM revemployee";
        List<RevisionEmployee> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                RevisionEmployee revisionEmployee = new RevisionEmployee(resultSet.getInt("idRevision"), resultSet.getInt("idEmployee"));
                objects.add(revisionEmployee);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

    public Boolean updateRevisionEmployeeByRevisionId(String updateColumns, Integer id){
        
        String sql = "CALL UpdateRowByColumnValue(?,?,?,?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, "revemployee");//table name
            statement.setString(2, updateColumns);//UpdateColumns
            statement.setString(3, "idRevision");// ColumnName
            statement.setInt(4, id);// SearchValue
            // uncomment if you need debugin
            // System.out.println("Executing SQL: " + sql);
            // System.out.println("Table: revemployee");
            // System.out.println("UpdateColumns: " + updateColumns);
            // System.out.println("ColumnName: id");
            // System.out.println("SearchValue: " + id);
            statement.executeUpdate();
            System.out.println("Revision relationship with employee updated successfully!");            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
