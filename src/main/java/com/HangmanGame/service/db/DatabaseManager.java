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
            String query = "SELECT * FROM users ORDER BY score DESC ";

            Statement statement = connections.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println(ConsoleColors.leaderBoard);
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "NICKNAME:            " + "SCORE:" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.line);

            while (resultSet.next()) {
                String nickname = resultSet.getString("nickname");
                int score = resultSet.getInt("score");


                System.out.println(nickname + "                " + score);
                System.out.println(ConsoleColors.line);
            }

            resultSet.close();
            statement.close();

            dbConnection.closeConnection(connections);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPoints(int points, String nickname) {
        String selectQuery = "SELECT score FROM users WHERE nickname = ?";
        String updateQuery = "UPDATE users SET score = ? WHERE nickname = ?";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
             PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            selectStatement.setString(1, nickname);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                int currentScore = resultSet.getInt("score");
                int newScore = currentScore + points;
                updateStatement.setInt(1, newScore);
                updateStatement.setString(2, nickname);
                updateStatement.executeUpdate();
            } else {
                System.out.println("Użytkownik o podanym nicku nie istnieje.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

