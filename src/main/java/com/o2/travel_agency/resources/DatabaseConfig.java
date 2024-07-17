package com.o2.travel_agency.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    // private static final String URL = "jdbc:mysql://root:fROuhtywvyxTqQcwaOLRXQhvSWEraqTO@monorail.proxy.rlwy.net:32436/railway";
    // private static final String USER = "root";
    // private static final String PASSWORD = "";

    // local test
    private static final String URL = "jdbc:mysql://localhost:3306/airport";
    private static final String USER = "campus2023";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
