package com.HangmanGame.db;

import java.util.Map;

public class WordsDatabase {

    public Map<String, String[]> getEasyWordDatabase() {
        return easyWordDatabase;
    }

    public Map<String, String[]> getHardWordDatabase() {
        return hardWordDatabase;
    }

    private final Map<String, String[]> easyWordDatabase = Map.of(
            "fruits", new String[]{"banana", "orange", "papaya", "cherry", "avocado"},
            "cars", new String[]{"citroen", "toyota", "renault", "ferrari", "porsche"},
            "vegetables", new String[]{"tomato", "potato", "pumpkin", "carrot", "broccoli"},
            "transports", new String[]{"airplane", "helicopter", "motorbike", "bicycle", "trolleybus"},
            "sweets", new String[]{"chocolate", "biscuit", "marzipan", "lollipop", "dessert"}
    );

    private final Map<String, String[]> hardWordDatabase = Map.of(
            "movies", new String[]{
                    "The Shawshank Redemption",
                    "The Lord of the Rings",
                    "The Green Mile",
                    "Raiders of the Lost Ark",
                    "The Dark Knight"},
            "books", new String[]{
                    "The Lord of the Rings",
                    "The Great Gatsby",
                    "To Kill a Mockingbird",
                    "The Lion, the Witch and the Wardrobe",
                    "THE BAZAAR OF BAD DREAMS"},
            "tourist destinations", new String[]{
                    "Blue Sea Islands",
                    "Colorful Meadow Mountains",
                    "Serene Waterfall Valley",
                    "High Peaks of the Western Range",
                    "Picturesque Golden Sand Coastline"},
            "sports", new String[]{
                    "Mixed Martial Arts",
                    "Formula 1 Racing",
                    "Mountain Bike Racing",
                    "Beach Volleyball",
                    "Ice Dance Skating"},
            "countries", new String[]{
                    "Bosnia and Herzegovina",
                    "United States of America",
                    "United Kingdom of Great Britain",
                    "Democratic Republic of the Congo"}
    );
}
