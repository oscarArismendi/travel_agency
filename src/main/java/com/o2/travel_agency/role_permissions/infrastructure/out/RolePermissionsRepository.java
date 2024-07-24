package com.o2.travel_agency.role_permissions.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.resources.DatabaseConfig;
import com.o2.travel_agency.role_permissions.domain.entity.RolePermissions;
import com.o2.travel_agency.role_permissions.domain.service.RolePermissionsService;

public class RolePermissionsRepository  implements RolePermissionsService {

    @Override
    public List<RolePermissions> listAllRolePermissions() {
        String sql = "SELECT role_id,permissions_id FROM role_permissions";
        List<RolePermissions> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                RolePermissions rolePermissions = new RolePermissions(resultSet.getInt("role_id"),resultSet.getInt("permissions_id"));
                objects.add(rolePermissions);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }

}
