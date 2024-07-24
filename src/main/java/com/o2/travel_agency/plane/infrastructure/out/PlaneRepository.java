package com.o2.travel_agency.plane.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.o2.travel_agency.plane.domain.entity.Plane;
import com.o2.travel_agency.plane.domain.entity.PlaneStMdDTO;
import com.o2.travel_agency.plane.domain.service.PlaneService;
import com.o2.travel_agency.resources.DatabaseConfig;

public class PlaneRepository implements PlaneService {

    @Override
    public Plane createPlane(Plane plane) {
        String query = "INSERT INTO plane (plates,capacity,fabricationDate,idAirline,idStatus,idModel) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(query,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, plane.getPlates());
            statement.setInt(2, plane.getCapacity());
            statement.setDate(3, plane.getFabricationDate());
            statement.setInt(4, plane.getIdAirline());
            statement.setInt(5, plane.getIdStatus());
            statement.setInt(6, plane.getIdModel());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    plane.setId(generatedKeys.getInt(1));
                }
                return plane;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Plane findPlaneByPlate(String plate){
        String sql = "CALL GetRowByColumnValue(?,?,?,?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, "id,plates,capacity,fabricationDate,idAirline,idStatus,idModel");
            statement.setString(2, "plane");
            statement.setString(3, "plates");
            statement.setString(4, "'"+plate+"'");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Retrieve values from result set
                int id = resultSet.getInt("id");
                String plates = resultSet.getString("plates");
                int capacity = resultSet.getInt("capacity");
                Date fabricationDate = resultSet.getDate("fabricationDate");
                int idAirline = resultSet.getInt("idAirline");
                int idStatus = resultSet.getInt("idStatus");
                int idModel = resultSet.getInt("idModel");
    
                // Create Plane object
                Plane plane = new Plane(id, plates, capacity, fabricationDate, idAirline, idStatus, idModel);
                return plane;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean updatePlaneByPlate(String updateColumns,String plate){
        String sql = "CALL UpdateRowByColumnValue(?,?,?,?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, "plane");//table name
            statement.setString(2, updateColumns);//UpdateColumns
            statement.setString(3, "plates");// ColumnName
            statement.setString(4, "'"+plate+"'");// SearchValue
            // uncomment if you need debugin
            // System.out.println("Executing SQL: " + sql);
            // System.out.println("Table: plane");
            // System.out.println("UpdateColumns: " + updateColumns);
            // System.out.println("ColumnName: plates");
            // System.out.println("SearchValue: " + plate);
            statement.executeUpdate();
            System.out.println("Plane updated successfully!");            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deletePlaneById(Integer id){
        String sql = "CALL DeleteFromTableById(?,?)";
        try(Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql,
        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, "plane");//table name
            statement.setInt(2, id);//searchValue
            statement.executeUpdate();
            System.out.println("Plane deleted successfully!");   
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public PlaneStMdDTO findPlaneStMdById(int id) {
        String sql = "SELECT p.id, p.plates, p.capacity, p.fabricationDate, ai.name AS 'airline', s.name AS 'status', m.name AS 'model' FROM plane p INNER JOIN statusA s ON  s.id = p.idStatus INNER JOIN model m ON m.id = p.idModel INNER JOIN airline ai ON ai.id = p.idAirline WHERE p.id = ?";
        try(Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql,
        PreparedStatement.RETURN_GENERATED_KEYS)){

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                PlaneStMdDTO plane = new PlaneStMdDTO(resultSet.getInt("id"), resultSet.getString("plates"),
                        resultSet.getInt("capacity"), resultSet.getDate("fabricationDate"), resultSet.getString("airline"),
                        resultSet.getString("status"), resultSet.getString("model"));
            return plane;
                
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

  
}
