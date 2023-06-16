package com.HangmanGame.menu;

import com.HangmanGame.service.HangmanMechanics;
import com.HangmanGame.service.db.DatabaseManager;

import java.util.Scanner;

public class MainMenu {
    private final HangmanMechanics hangmanMechanics = new HangmanMechanics();
    private final DatabaseManager databaseManager;

    public MainMenu() {
        com.HangmanGame.service.db.DatabaseConnection databaseConnection = new com.HangmanGame.service.db.DatabaseConnection();
        databaseManager = new DatabaseManager(databaseConnection);
    }

    Scanner scn = new Scanner(System.in);
    String nickname;

    public void welcome() {
        System.out.println(ConsoleColors.welcomeString);
        System.out.println("Welcome to Hangman game" + ", please enter you nickname:");
        nickname = scn.nextLine();
        databaseManager.insertUser(nickname,0);
        System.out.println();
        showMenu();
    }

    public void showMenu() {
        System.out.println(ConsoleColors.stars + "\n");
        System.out.println("Enter your choice: ");
        System.out.println("1. Start Game");
        System.out.println("2. Game Rules");
        System.out.println("3. Show Scoreboard");
        System.out.println("4. Exit");
        processPlayerChoice();
    }

    private void processPlayerChoice() {
        int playerChose = getPlayerChose();
        switch (playerChose) {
            case 1 -> choseDifficulty();
            case 2 -> {
                hangmanMechanics.showGameRules();
                showMenu();
            }
            case 3 -> {
                databaseManager.showScoreboard();
                showMenu();
            }
            case 4 -> hangmanMechanics.endGame();
            default -> {
                System.out.println("Enter valid number");
                scn.nextLine();
                showMenu();
            }
        }
    }

    private void choseDifficulty() {
        System.out.println("""
                Select difficulty level:\s
                 1: Normal
                 2: Hard
                 3: Back""");
        switch (getPlayerChose()) {
            case 1 -> hangmanMechanics.startGame(true);
            case 2 -> hangmanMechanics.startGame(false);
            case 3 -> showMenu();
            default -> System.out.println("Enter valid number");
        }
    }

    private int getPlayerChose() {
        while (!scn.hasNextInt()) {
            scn.nextLine();
            System.out.println("Enter valid number");
        }
        return scn.nextInt();
    }
}