# Hangman Game

Hangman Game is a simple command-line game implemented in Java. The game allows players to guess letters in order to reveal a hidden word and win the game. The project consists of multiple classes responsible for different functionalities, such as word generation, game mechanics, and database management.
![image](https://github.com/Wasiewicz/Hangman-Game/assets/124580574/16153161-64b9-443e-bed0-02bec9a01aeb)

![image](https://github.com/Wasiewicz/Hangman-Game/assets/124580574/d96b6c8c-e15b-4a35-aaed-8b2f2b0fa436)
![image](https://github.com/Wasiewicz/Hangman-Game/assets/124580574/0dea228e-16bc-4a3c-a93f-c41e2083e821)
![image](https://github.com/Wasiewicz/Hangman-Game/assets/124580574/d6f964a7-aaa3-4574-8f78-28bcbc7976ed)



## Prerequisites

To run the Hangman Game, ensure that you have the following installed on your system:

- Java Development Kit (JDK)
- MySQL

## Installation

1. Clone the repository or download the source code.
2. Import the project into your preferred Java IDE.
3. Set up the MySQL database by executing the provided SQL script (`hangman_game.sql`).

## Usage

1. Run the `Main` class to start the Hangman Game.
2. Enter your nickname when prompted.
3. Select an option from the main menu:
   - **Start Game**: Choose the difficulty level (Normal or Hard) and begin playing.
   - **Show Scoreboard**: View the leaderboard showing the top players and their scores.
   - **Exit**: Quit the game.
4. During the game, guess letters to reveal the hidden word. The number of lives remaining will be displayed.
5. If you guess the word correctly, you win the game and earn points based on the difficulty level.
6. If you run out of lives, you lose the game.

## Classes

The project consists of the following classes:

- `HangmanMechanics`: Handles the game mechanics, including word generation, difficulty selection, player input, and game outcomes.
- `MainMenu`: Displays the main menu and handles user input for menu options.
- `DatabaseManager`: Manages the connection to the MySQL database, inserts user records, displays the leaderboard, and updates user scores.
- `DatabaseConnection`: Handles the connection to the MySQL database and provides methods to establish and close connections.
- `EasyWord` and `HardWord`: Implement the `WordDataProvider` interface and generate random words from the database based on the difficulty level.


## License

The Hangman Game project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
