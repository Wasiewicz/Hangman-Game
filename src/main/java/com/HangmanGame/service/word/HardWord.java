package com.HangmanGame.service.word;

import com.HangmanGame.db.WordsDatabase;

import java.util.Random;
import java.util.Set;

public class HardWord implements WordDataProvider {
    private final WordsDatabase wordsDatabase;

    public HardWord(WordsDatabase wordsDatabase) {
        this.wordsDatabase = wordsDatabase;
    }

    @Override
    public String getRandomCategory() {
        Set<String> categories = wordsDatabase.getHardWordDatabase().keySet();
        int randomInt = new Random().nextInt(categories.size());
        return categories
                .stream()
                .skip(randomInt)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getRandomWord(String category) {
        String[] word = wordsDatabase.getHardWordDatabase().get(category);
        int randomIndex = new Random().nextInt(word.length);
        return word[randomIndex];
    }


}
