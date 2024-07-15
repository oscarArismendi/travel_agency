package com.o2.travel_agency.status.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.resources.DatabaseConfig;
import com.o2.travel_agency.status.domain.entity.Status;
import com.o2.travel_agency.status.service.StatusService;

public class StatusRepository implements StatusService {

    @Override
    public List<Status> listAllStatus() {
        String sql = "SELECT id, name FROM statusA";
        List<Status> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Status status = new Status(resultSet.getInt("id"), resultSet.getString("name"));
                objects.add(status);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
