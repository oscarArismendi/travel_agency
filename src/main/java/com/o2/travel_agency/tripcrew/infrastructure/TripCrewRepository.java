package com.o2.travel_agency.tripcrew.infrastructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.resources.DatabaseConfig;
import com.o2.travel_agency.tripcrew.domain.entity.TripCrew;
import com.o2.travel_agency.tripcrew.domain.service.TripCrewService;

public class TripCrewRepository implements TripCrewService {

    @Override
    public List<TripCrew> listAllTripCrew() {
        String sql = "SELECT id, name FROM tripcrew";
        List<TripCrew> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                TripCrew tripCrew = new TripCrew(resultSet.getInt("id"), resultSet.getString("name"));
                objects.add(tripCrew);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

    @Override
    public TripCrew RegisterTripCrew(TripCrew tripCrew) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'RegisterTripCrew'");
    }
    
}
