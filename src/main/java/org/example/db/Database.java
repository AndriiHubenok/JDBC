package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class Database {
    private static final String DB_URL = "jdbc:h2:/Users/user/IdeaProjects/JDBC/test";
    private Connection connection;
    private static Database instance;

    private Database() {
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (Objects.isNull(connection)) {
            connection = DriverManager.getConnection(DB_URL);
        }
        return connection;
    }
}
