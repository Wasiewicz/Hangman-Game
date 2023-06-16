package com.HangmanGame.service.db;

import com.HangmanGame.menu.ConsoleColors;

import java.sql.*;

public class DatabaseManager {
    private final DatabaseConnection dbConnection;

    public DatabaseManager(DatabaseConnection connection) {
        this.dbConnection = connection;
    }

    public void insertUser(String nickname, int score) {
        String sql = "INSERT INTO users (nickname, score) VALUES (?, ?)";
        try (Connection connections = dbConnection.getConnection();
             PreparedStatement stmt = connections.prepareStatement(sql)) {
            stmt.setString(1, nickname);
            stmt.setInt(2, score);
            stmt.executeUpdate();
        } catch (SQLException e) {
            if (!(e instanceof SQLIntegrityConstraintViolationException))
                e.printStackTrace();
        }
    }

    public void showScoreboard() {
        try {
            Connection connections = dbConnection.getConnection();

            String query = "SELECT * FROM users";
            Statement statement = connections.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String nickname = resultSet.getString("nickname");
                int score = resultSet.getInt("score");
                System.out.println(ConsoleColors.leaderBoard);
                System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "NICKNAME:            " + "SCORE:" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.line);
                System.out.println(nickname + "                " + score);
                System.out.println(ConsoleColors.line + "\n");
            }

            resultSet.close();
            statement.close();

            dbConnection.closeConnection(connections);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
