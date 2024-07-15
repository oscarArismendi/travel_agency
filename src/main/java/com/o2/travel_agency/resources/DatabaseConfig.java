package com.o2.travel_agency.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://root:xUoZmGJFApacSMAoJthjLcikhPtegtoz@roundhouse.proxy.rlwy.net:26366/railway";
    private static final String USER = "root";
    private static final String PASSWORD = "xUoZmGJFApacSMAoJthjLcikhPtegtoz";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
