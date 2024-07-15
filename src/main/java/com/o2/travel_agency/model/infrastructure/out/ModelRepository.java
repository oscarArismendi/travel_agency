package com.o2.travel_agency.model.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.o2.travel_agency.model.domain.entity.Model;
import com.o2.travel_agency.model.domain.service.ModelService;
import com.o2.travel_agency.resources.DatabaseConfig;

public class ModelRepository implements ModelService{

    @Override
    public List<Model> listAllModels(){
        String sql = "SELECT id, name,manufacturerId FROM model";
        List<Model> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Model model = new Model(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getInt("manufacturerId"));
                objects.add(model);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
