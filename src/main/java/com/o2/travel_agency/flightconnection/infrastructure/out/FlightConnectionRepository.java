package com.o2.travel_agency.flightconnection.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.flightconnection.domain.entity.FlightConnection;
import com.o2.travel_agency.flightconnection.domain.service.FlightConectionService;
import com.o2.travel_agency.resources.DatabaseConfig;

public class FlightConnectionRepository implements FlightConectionService {

    @Override
    public List<FlightConnection> listAllFlightConnection() {
        String sql = "SELECT id, connectionNumber,idTrip,idPlane,idAirport FROM flightconnection";
        List<FlightConnection> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                FlightConnection flightConnection = new FlightConnection(resultSet.getInt("id"), resultSet.getString("connectionNumber"),
                resultSet.getInt("idTrip"), resultSet.getInt("idPlane"),  resultSet.getInt("idAirport"));
                objects.add(flightConnection);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

    @Override
    public Boolean deleteFlightConnectionById(Integer id) {
        String query = "DELETE FROM documenttype WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("document type deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at deleting the document type: " + e.getMessage());
        }
        return false;

    }
    

    @Override
    public Boolean updateFlightConneciontById(String updateColumns, Integer id) {
        
        String query = "UPDATE documenttype SET " + updateColumns + " WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Document type updated successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at updating the airport: " + e.getMessage());
        }
        return false;
    }
    
}
