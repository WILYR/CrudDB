package com.wilyr.crud.repository.mySqlRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractRepository {

    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud?serverTimezone=Europe/Moscow";
    static final String USER = "root";
    static final String PASSWORD = "ybrbnf22";

    Connection connection = setConnection();
    Statement statement = null;

    protected Connection setConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            return null;
        }
    }
}
