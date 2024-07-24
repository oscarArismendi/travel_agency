package com.o2.travel_agency.flightfare.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.flightfare.domain.entity.FlightFare;

import com.o2.travel_agency.flightfare.domain.service.FlightFareService;
import com.o2.travel_agency.resources.DatabaseConfig;

public class FlightFareRepository implements FlightFareService {
    @Override
    public FlightFare createFlightfare(FlightFare flightFare) {
        String sql = "INSERT INTO flightfare (id, description, details, value) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql,
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, flightFare.getId());
            statement.setString(2, flightFare.getDescription());
            statement.setString(3, flightFare.getDetails());
            statement.setDouble(4, flightFare.getValue());

            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    flightFare.setId(generatedKeys.getInt(1));
                }
                System.out.println("Flightfare created successfully!");
                return flightFare;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at creating a flightfare: " + e.getMessage());
        }
        return null;
    }

    @Override
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

    @Override
    public Boolean updateFlightfareById(String updateColumns, int id) {
        String query = "UPDATE flightfare SET " + updateColumns + " WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Flight fare updated successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at updating the flightfare: " + e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean deleteFlightFareById(Integer id) {
        String query = "DELETE FROM flightfare WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Flight fare deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at deleting the flightfare: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<FlightFare> listAllFlightFareUseCase() {
        String sql = "SELECT id, description, details,value FROM flightfare";
        List<FlightFare> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                FlightFare flightFare = new FlightFare(resultSet.getInt("id"), resultSet.getString("description"),resultSet.getString("details"),resultSet.getDouble("value"));
                objects.add(flightFare);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

}
