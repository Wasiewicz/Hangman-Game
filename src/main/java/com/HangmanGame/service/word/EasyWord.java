package com.HangmanGame.service.word;

import com.HangmanGame.db.WordsDatabase;

import java.util.Random;
import java.util.Set;

public class EasyWord implements WordDataProvider {
    public EasyWord(WordsDatabase wordsDatabase) {
        this.wordsDatabase = wordsDatabase;
    }

    private final WordsDatabase wordsDatabase;

    @Override
    public String getRandomCategory() {
        Set<String> categories = wordsDatabase.getEasyWordDatabase().keySet();
        int randomInt = new Random().nextInt(categories.size());
        return categories
                .stream()
                .skip(randomInt)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getRandomWord(String category) {
        String[] words = wordsDatabase.getEasyWordDatabase().get(category);
        return words[new Random().nextInt(words.length)];
    }
}