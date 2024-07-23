package com.o2.travel_agency.tripulationRoles.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.resources.DatabaseConfig;
import com.o2.travel_agency.tripulationRoles.domain.entity.TripulationRole;
import com.o2.travel_agency.tripulationRoles.domain.service.TripulationRoleService;

public class TripulationRoleRepository implements TripulationRoleService {

    

    @Override
    public List<TripulationRole> ListAllTripulationRoles() {
        String sql = "SELECT id, name From tripulationroles";
        List<TripulationRole> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
                TripulationRole tripulationRole = new TripulationRole(resultSet.getInt("id"), resultSet.getString("name"));
                objects.add(tripulationRole);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
    
}
