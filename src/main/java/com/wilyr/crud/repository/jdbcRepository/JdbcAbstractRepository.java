package com.wilyr.crud.repository.jdbcRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public interface JdbcAbstractRepository {



    default Connection setConnection() {
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud?serverTimezone=Europe/Moscow";
        final String USER = "root";
        final String PASSWORD = "******";

        Connection connection = setConnection();
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            return null;
        }
    }
}
