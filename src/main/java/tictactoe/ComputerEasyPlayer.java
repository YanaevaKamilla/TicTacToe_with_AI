package tictactoe;

import java.util.Random;
import java.util.Scanner;

// Define the ComputerEasyPlayer class, a subclass of ComputerPlayer, representing a simple AI player
class ComputerEasyPlayer extends ComputerPlayer {

    // Random number generator for making random moves
    private final Random random;

    public ComputerEasyPlayer(char symbol) {
        super(symbol);
        random = new Random();
    }

    // Implementation to make a random move on the game board
    @Override
    public void makeMove(char[][] gameField, Scanner scanner) {
        while (true) {
            int coordinateX = random.nextInt(gameField.length);
            int coordinateY = random.nextInt(gameField[0].length);

            if (gameField[coordinateX][coordinateY] == ' ') {
                gameField[coordinateX][coordinateY] = symbol;
                break;
            }
        }
    }
}
