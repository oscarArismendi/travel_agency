package com.o2.travel_agency.trip.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.resources.DatabaseConfig;
import com.o2.travel_agency.trip.domain.entity.Trip;
import com.o2.travel_agency.trip.domain.service.TripService;

public class TripRepository implements TripService {

    @Override
    public List<Trip> listAllTrip() {
        String sql = "SELECT id, tripDate, priceTrip, idDestination, idOrigin  FROM trip";
        List<Trip> trips = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Trip trip = new Trip(
                    resultSet.getInt("id"),
                    resultSet.getDate("tripDate"),
                    resultSet.getDouble("priceTrip"),
                    resultSet.getInt("idOrigin"),
                    resultSet.getInt("idDestination")
                );
                trips.add(trip);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trips;
    }

    @Override
    public Boolean updateTripById(String updateColumns, Integer id) {
        String query = "UPDATE trip SET " + updateColumns + " WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Trip updated successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at updating the trip: " + e.getMessage());
        }
        return false;
    }
    

    @Override
    public Boolean deleteDocumentTypeById(Integer id) {
        String query = "DELETE FROM trip WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Trip deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at deleting the trip: " + e.getMessage());
        }
        return false;

    }
    
    
}
