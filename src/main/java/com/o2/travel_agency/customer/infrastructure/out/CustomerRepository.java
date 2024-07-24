package com.o2.travel_agency.customer.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.o2.travel_agency.customer.domain.entity.Customer;
import com.o2.travel_agency.customer.domain.service.CustomerService;
import com.o2.travel_agency.resources.DatabaseConfig;

public class CustomerRepository implements CustomerService {
    @Override
    public Customer findCustomerByNroIdc(Integer nroIdc) {
        String sql = "CALL GetRowByColumnValue(?,?,?,?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, "id,firstName,lastName,age,nroIdc,idDocument");// SelectColumns
            statement.setString(2, "customer");// TableName
            statement.setString(3, "nroIdc");// ColumnName
            statement.setInt(4, nroIdc);// SearchValue
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Retrieve values from result set
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                int newNroIdc = resultSet.getInt("nroIdc");
                int idDocument = resultSet.getInt("idDocument");

                // Create customer object
                Customer customer = new Customer(id, firstName, lastName, age, newNroIdc, idDocument);
                return customer;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

        @Override
    public Customer createCustomer(Customer customer) {
        String sql = "INSERT INTO customer (firstName,lastName,age,nroIdc,idDocument) VALUES (?, ?, ?, ?,?)";

        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql,
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setInt(3, customer.getAge());
            statement.setInt(4, customer.getNroIdc());
            statement.setInt(5, customer.getIdDocument());

            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customer.setId(generatedKeys.getInt(1));
                }
                System.out.println("Customer created successfully!");
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error at creating a customer: " + e.getMessage());
        }
        return null;
    }
}
