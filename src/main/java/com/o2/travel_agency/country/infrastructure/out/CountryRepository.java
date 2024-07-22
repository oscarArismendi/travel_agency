package com.o2.travel_agency.country.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.country.domain.entity.Country;
import com.o2.travel_agency.country.domain.service.CountryService;
import com.o2.travel_agency.resources.DatabaseConfig;

public class CountryRepository implements CountryService {
    @Override
    public List<Country> listAllCountries(){
        
        String sql = "SELECT id, name FROM country";
        List<Country> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Country country = new Country(resultSet.getInt("id"), resultSet.getString("name"));
                objects.add(country);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
