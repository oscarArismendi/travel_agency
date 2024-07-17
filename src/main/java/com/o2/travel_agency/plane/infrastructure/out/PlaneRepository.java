package com.o2.travel_agency.plane.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.o2.travel_agency.plane.domain.entity.Plane;
import com.o2.travel_agency.plane.domain.service.PlaneService;
import com.o2.travel_agency.resources.DatabaseConfig;

public class PlaneRepository implements PlaneService {

    @Override
    public Plane createPlane(Plane plane) {
        String sql = "INSERT INTO plane (plates,capacity,fabricationDate,idAirline,idStatus,idModel) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, plane.getPlates());
            statement.setInt(2, plane.getCapacity());
            statement.setDate(3, plane.getFabricationDate());
            statement.setInt(4, plane.getIdAirline());
            statement.setInt(5, plane.getIdModel());
            statement.setInt(6, plane.getIdModel());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    plane.setId(generatedKeys.getInt(1));
                }
                return plane;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
