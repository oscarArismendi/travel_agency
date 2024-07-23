package com.o2.travel_agency.flightfare.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.o2.travel_agency.flightfare.domain.entity.FlightFare;

import com.o2.travel_agency.flightfare.domain.service.FlightfareService;
import com.o2.travel_agency.resources.DatabaseConfig;

public class FlightFareRepository implements FlightfareService {

    public void createFlightfare(FlightFare flightFare) {
        String query = "INSERT INTO flightfare (id, description, details, value) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, flightFare.getId());
            preparedStatement.setString(2, flightFare.getDescription());
            preparedStatement.setString(3, flightFare.getDetails());
            preparedStatement.setDouble(4, flightFare.getValue());

            preparedStatement.executeUpdate();
            System.out.println("Flightfare created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at creating a flightfare: " + e.getMessage());
        }
    }


    public FlightFare findFlightfareById(Integer id) {
        String query = "SELECT * FROM flightfare WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int flightfareId = resultSet.getInt("id");
                String description = resultSet.getString("description");
                String details = resultSet.getString("details");
                double value = resultSet.getDouble("value");

                return new FlightFare(flightfareId, description, details, value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at finding the flightfare: " + e.getMessage());
        }
        return null;
    }


    public Boolean updateFlightfareById(String updateColumns, int id) {
        String query = "UPDATE flightfare SET " + updateColumns + " WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Flightfare updated successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at updating the flightfare: " + e.getMessage());
        }
        return false;
    }

    
    public Boolean deleteFlightFareById(Integer id) {
        String query = "DELETE FROM flightfare WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Flightfare deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at deleting the flightfare: " + e.getMessage());
        }
        return false;
    }

    @Override
    public String toString() {
        return "FlightFareRepository []";
    }


    @Override
    public void RegisterDocument(FlightFare flightFare) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'RegisterDocument'");
    }


    @Override
    public Boolean deleteFlightFareTypeById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFlightFareTypeById'");
    }


    @Override
    public List<FlightFare> ListAllFlightFareUseCase() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ListAllFlightFareUseCase'");
    }
}
