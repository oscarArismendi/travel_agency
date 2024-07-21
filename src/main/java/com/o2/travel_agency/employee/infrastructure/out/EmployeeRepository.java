package com.o2.travel_agency.employee.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.o2.travel_agency.employee.domain.entity.Employee;
import com.o2.travel_agency.employee.domain.service.EmployeeService;
import com.o2.travel_agency.resources.DatabaseConfig;

public class EmployeeRepository implements EmployeeService {
    @Override
    public List<Employee> listAllEmployees() {

        String sql = "SELECT id, name,ingressDate,idRol,idUserRole,idAirline,idAirport,email,password FROM employee";
        List<Employee> objects = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getDate("ingressDate"), resultSet.getInt("idRol"), resultSet.getInt("idUserRole"),
                        resultSet.getInt("idAirline"), resultSet.getInt("idAirport"), resultSet.getString("email"),
                        resultSet.getString("password"));
                objects.add(employee);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objects;
    }
}
