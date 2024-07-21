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

    @Override
    public Revision createRevision(Revision revision){
        String sql = "INSERT INTO revision (revisionDate,idPlane,description) VALUES (?,?,?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setDate(1, revision.getRevisionDate());
            statement.setInt(2, revision.getIdPlane());
            statement.setString(3, revision.getDescription());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    revision.setId(generatedKeys.getInt(1));
                }
                return revision;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean deleteRevision(Integer id){
        String sql = "CALL DeleteFromTableById(?,?)";
        try(Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql,
        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, "revision");//table name
            statement.setInt(2, id);//searchValue
            statement.executeUpdate();
            System.out.println("Revision deleted successfully!");   
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean updateRevisionById(String updateColumns,Integer id){

        String sql = "CALL UpdateRowByColumnValue(?,?,?,?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, "revision");//table name
            statement.setString(2, updateColumns);//UpdateColumns
            statement.setString(3, "id");// ColumnName
            statement.setInt(4, id);// SearchValue
            // uncomment if you need debugin
            // System.out.println("Executing SQL: " + sql);
            // System.out.println("Table: revision");
            // System.out.println("UpdateColumns: " + updateColumns);
            // System.out.println("ColumnName: id");
            // System.out.println("SearchValue: " + id);
            statement.executeUpdate();
            System.out.println("Revision updated successfully!");            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
