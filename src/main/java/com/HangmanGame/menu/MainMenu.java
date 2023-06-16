package com.HangmanGame.menu;

import com.HangmanGame.service.HangmanMechanics;
import com.HangmanGame.service.db.DatabaseManager;

import java.util.Scanner;

public class MainMenu {
    private final HangmanMechanics hangmanMechanics;
    private final DatabaseManager databaseManager;
    private String nickname;

    public MainMenu(HangmanMechanics hangmanMechanics) {
        com.HangmanGame.service.db.DatabaseConnection databaseConnection = new com.HangmanGame.service.db.DatabaseConnection();
        databaseManager = new DatabaseManager(databaseConnection);
        this.hangmanMechanics = hangmanMechanics;
    }

    Scanner scn = new Scanner(System.in);

    public void welcome() {
        System.out.println(ConsoleColors.welcomeString);
        System.out.println("Welcome to Hangman game" + ", please enter you nickname:");
        nickname = scn.nextLine();
        databaseManager.insertUser(nickname, 0);
        System.out.println();
        showMenu();
    }


    public void showMenu() {
        System.out.println("\n" + ConsoleColors.stars + "\n");
        System.out.println("Enter your choice: ");
        System.out.println("1. Start Game");
        System.out.println("2. Game Rules");
        System.out.println("3. Show Scoreboard");
        System.out.println("4. Exit");
        processPlayerChoice();
    }

    private void processPlayerChoice() {
        int playerChoice = getPlayerChoice();
        switch (playerChoice) {
            case 1 -> chooseDifficulty();
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

    private void chooseDifficulty() {
        System.out.println("""
                Select difficulty level:\s
                 1: Normal
                 2: Hard
                 3: Back""");
        switch (getPlayerChoice()) {
            case 1 -> hangmanMechanics.startGame(true, nickname);
            case 2 -> hangmanMechanics.startGame(false, nickname);
            case 3 -> showMenu();
            default -> System.out.println("Enter valid number");
        }
    }


    private int getPlayerChoice() {
        while (!scn.hasNextInt()) {
            scn.nextLine();
            System.out.println("Enter valid number");
        }
        return scn.nextInt();
    }
}