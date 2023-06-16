package com.HangmanGame;

import com.HangmanGame.menu.MainMenu;
import com.HangmanGame.service.HangmanMechanics;

public class HangmanGame {


    public static void main(String[] args) {
        HangmanMechanics hangmanMechanics = new HangmanMechanics();
        MainMenu mainMenu = new MainMenu(hangmanMechanics);
        mainMenu.welcome();
    }
}