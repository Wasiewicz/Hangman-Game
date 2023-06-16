package com.HangmanGame.service.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public final String url;
    public final String username;
    public final String password;

    public DatabaseConnection() {
        this.url = "jdbc:mysql://localhost:3306/hangman_game";
        this.username = "root";
        this.password = "Kamil";
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
