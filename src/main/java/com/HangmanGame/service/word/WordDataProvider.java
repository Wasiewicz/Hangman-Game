package com.HangmanGame.service.word;

public interface WordDataProvider {
    String getRandomWord(String category);
    String getRandomCategory();
}
