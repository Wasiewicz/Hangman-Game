package com.HangmanGame.menu;

import com.HangmanGame.service.HangmanMechanics;

import java.util.Scanner;

public class MainMenu {
    public MainMenu(HangmanMechanics hangmanMechanics) {
        this.hangmanMechanics = hangmanMechanics;
    }

    private final HangmanMechanics hangmanMechanics;
    Scanner scn = new Scanner(System.in);
    String nickname;

    public void welcome() {
        System.out.println(ConsoleColors.welcomeString);
        System.out.println("Welcome to Hangman game" + ", please enter you nickname:");
        nickname = scn.nextLine();
        System.out.println();
        showMenu();

    }

    private void showMenu() {
        System.out.println(ConsoleColors.stars + "\n");
        System.out.println("Enter your choice: ");
        System.out.println("1. Start Game");
        System.out.println("2. Game Rules");
        System.out.println("3. Show Scoreboard");
        System.out.println("4. Exit");
        playerChose();
    }

    private void playerChose() {
        int playerChose = getPlayerChose();
        switch (playerChose) {
            case 1 ->{
                hangmanMechanics.startGame();
                //pickDifficultyLevel();
            }
            case 2 -> hangmanMechanics.showGameRules();
            case 3 -> hangmanMechanics.showScoreboard();
            case 4 -> hangmanMechanics.endGame();
            default -> {
                System.out.println("Enter valid number");
                scn.nextLine();
                showMenu();
            }
        }
    }

    private int getPlayerChose() {
        while (!scn.hasNextInt()) {
            scn.nextLine();
            System.out.println("Enter valid number");
        }
        return scn.nextInt();
    }

//    private void pickDifficultyLevel() {
//        System.out.println("Choose a difficulty level: ");
//        System.out.println("1. Normal");
//        System.out.println("2. Hard");
//        System.out.println("3. Back");
//        int playerChose = getPlayerChose();
//        switch (playerChose){
//
//        }
//    }
}


