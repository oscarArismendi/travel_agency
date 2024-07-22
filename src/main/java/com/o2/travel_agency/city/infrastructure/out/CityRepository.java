package com.o2.travel_agency.city.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.city.domain.entity.City;
import com.o2.travel_agency.city.domain.service.CityService;
import com.o2.travel_agency.resources.DatabaseConfig;

public class CityRepository implements CityService {
    @Override
    public List<City> listAllCities() {
        String sql = "SELECT id, name, idCountry FROM city";
        List<City> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                City city = new City(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getInt("idCountry"));
                objects.add(city);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
