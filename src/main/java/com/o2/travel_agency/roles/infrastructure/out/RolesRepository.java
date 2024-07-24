package com.o2.travel_agency.roles.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.resources.DatabaseConfig;
import com.o2.travel_agency.roles.domain.entity.Roles;
import com.o2.travel_agency.roles.domain.service.RolesService;

public class RolesRepository implements RolesService {

    @Override
    public List<Roles> listAllRoles() {
        String sql = "SELECT id, name_role FROM roles";
        List<Roles> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Roles roles = new Roles(resultSet.getInt("id"), resultSet.getString("name_role"));
                objects.add(roles);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

}
