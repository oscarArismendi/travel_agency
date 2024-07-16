package com.o2.travel_agency.airline.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.airline.domain.entity.Airline;
import com.o2.travel_agency.airline.domain.service.AirlineService;
import com.o2.travel_agency.resources.DatabaseConfig;

public class AirlineRepository implements AirlineService {

    @Override
    public List<Airline> listAllAirlines() {

        String sql = "SELECT id, name FROM airline";
        List<Airline> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Airline airline = new Airline(resultSet.getInt("id"), resultSet.getString("name"));
                objects.add(airline);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;

    }
}
