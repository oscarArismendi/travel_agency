package com.o2.travel_agency.airport.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.o2.travel_agency.airport.domain.entity.Airport;
import com.o2.travel_agency.resources.DatabaseConfig;

public class AirportRepository {

    public void createAirport(Airport airport) {
        String query = "INSERT INTO airport (id, name, id_city) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, airport.getId());
            preparedStatement.setString(2, airport.getName());
            preparedStatement.setLong(3, airport.getIdCity());

            preparedStatement.executeUpdate();
            System.out.println("Airport created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at creating an airport: " + e.getMessage());
        }
    }

    public Airport findAirportById(Integer id) {
        String query = "SELECT * FROM airport WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int airportId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int idCity = resultSet.getInt("id_city");

                return new Airport(airportId, name, idCity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at finding the airport: " + e.getMessage());
        }
        return null;
    }

    public boolean updateAirportById(String updateColumns, int id) {
        String query = "UPDATE airport SET " + updateColumns + " WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Airport updated successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at updating the airport: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteAirportById(Integer id) {
        String query = "DELETE FROM airport WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Airport deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at deleting the airport: " + e.getMessage());
        }
        return false;
    }
}
//correción de airport repository