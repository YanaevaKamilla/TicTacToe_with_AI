package tictactoe;

import java.util.Scanner;

// Define the base class for players
class Player {
    protected char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    // Default implementation does nothing
    public void makeMove(char[][] gameField, Scanner scanner) {
    }
}
