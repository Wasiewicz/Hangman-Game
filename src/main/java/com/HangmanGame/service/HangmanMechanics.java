package com.HangmanGame.service;

import com.HangmanGame.db.WordsDatabase;
import com.HangmanGame.menu.ConsoleColors;
import com.HangmanGame.menu.MainMenu;
import com.HangmanGame.service.word.EasyWord;
import com.HangmanGame.service.word.HardWord;

import java.util.Arrays;
import java.util.Scanner;

public class HangmanMechanics {
    private final WordsDatabase wordsDatabase = new WordsDatabase();
    private final EasyWord easyWord = new EasyWord(wordsDatabase);
    private final HardWord hardWord = new HardWord(wordsDatabase);
    private final Scanner scn = new Scanner(System.in);
    private int lives = 3;
    private boolean playerTurn = true;


    public void startGame(boolean isNormalDifficulty) {
        if (isNormalDifficulty)
            setNormalDifficulty();
        else
            setHardDifficulty();
    }

    private void setDifficulty(String category, String randomWord) {
        StringBuilder maskedWord = new StringBuilder();
        char[] wordChars = randomWord.toLowerCase().toCharArray();
        initializeGame(maskedWord, wordChars);
        System.out.println("Category: " + category + " Word: " + Arrays.toString(wordChars) + " " + maskedWord);

        while (playerTurn)
            getCharEnterByPlayer(category, maskedWord, wordChars, randomWord.toLowerCase());
    }

    private void initializeGame(StringBuilder maskedWord, char[] wordChars) {
        for (char wordChar : wordChars)
            maskedWord.append(wordChar == ' ' ? ' ' : '_');

        System.out.println("Your lives: " + lives);
    }

    private void setNormalDifficulty() {
        String randomCategory = easyWord.getRandomCategory();
        String randomWord = easyWord.getRandomWord(randomCategory);
        setDifficulty(randomCategory, randomWord.toLowerCase());
    }

    private void setHardDifficulty() {
        String randomCategory = hardWord.getRandomCategory();
        String randomWord = hardWord.getRandomWord(randomCategory);
        setDifficulty(randomCategory, randomWord);
    }

    private void getCharEnterByPlayer(String randomCategory, StringBuilder maskedWord, char[] wordChars, String randomWord) {
        char[] playerChar = scn.nextLine().toLowerCase().toCharArray();
        if (playerChar.length == 0) System.out.println("Enter the letter of your choice");
        else {
            boolean letterGuessed = false;
            for (int i = 0; i < wordChars.length; i++) {
                if (wordChars[i] == playerChar[0]) {
                    maskedWord.setCharAt(i, playerChar[0]);
                    letterGuessed = true;
                }
            }
            if (!letterGuessed) {
                lives--;
                System.out.println("Wrong guess. Lives remaining: " + lives);
                if (lives <= 0) {
                    playerTurn = false;
                    loseGame();
                    return;
                }
            }

        }
        System.out.println("Category: " + randomCategory + " Word: " + Arrays.toString(wordChars) + " " + maskedWord);
        if (maskedWord.toString().equals(randomWord)) {
            playerTurn = false;
            winGame();


        }
    }

    public void endGame() {
        System.out.println(ConsoleColors.goodbayString);
    }

    public boolean winGame() {
        System.out.println(ConsoleColors.win);
        oneMoreGame();
        return true;
    }

    public void loseGame() {
        System.out.println(ConsoleColors.lose);
        oneMoreGame();
    }

    private void oneMoreGame() {
        System.out.println("""
                Dou you wanna play one more time ?
                1: Yes
                2: No""");
        if (scn.nextInt() == 1) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.showMenu();
            return;
        }
        endGame();
    }

    public void showGameRules() {
        System.out.println("game rules");
    }
}

