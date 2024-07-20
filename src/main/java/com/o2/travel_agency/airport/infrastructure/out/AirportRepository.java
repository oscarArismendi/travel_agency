package com.o2.travel_agency.airport.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.o2.travel_agency.airport.domain.entity.Airport;
import com.o2.travel_agency.resources.DatabaseConfig;

public class AirportRepository {
    public void save(Airport airport) {
        String query = "INSERT INTO airport (id, name, city, country) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, airport.getId());
            preparedStatement.setString(2, airport.getName());
            preparedStatement.setString(3, airport.getCity());
            preparedStatement.setString(4, airport.getCountry());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

