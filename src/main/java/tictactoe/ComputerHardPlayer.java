package tictactoe;

import java.util.Scanner;

// Define the ComputerHardPlayer class, a subclass of ComputerPlayer, representing a hard level AI player
class ComputerHardPlayer extends ComputerPlayer {

    public ComputerHardPlayer(char symbol) {
        super(symbol);
    }

    // Implementation to make a hard-level move on the game board using the minimax algorithm
    @Override
    public void makeMove(char[][] gameField, Scanner scanner) {
        int[] bestMove = minimax(gameField, symbol, 0);
        gameField[bestMove[0]][bestMove[1]] = symbol;
    }

    // evaluate: Evaluates the game board and returns a score based on the player's winning chances
    private int evaluate(char[][] gameField) {
        if (checkWin(gameField, symbol)) {
            return 10;
        } else if (checkWin(gameField, getOpponentSymbol(symbol))) {
            return -10;
        } else {
            return 0;
        }
    }

    // isMovesLeft: Checks if there are any available moves left on the game board
    private boolean isMovesLeft(char[][] gameField) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (gameField[row][col] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    // getOpponentSymbol: Returns the symbol of the opponent (the opposite of the player's symbol)
    private char getOpponentSymbol(char symbol) {
        return (symbol == 'X') ? 'O' : 'X';
    }

    // minimax: The minimax algorithm for finding the best move for the AI player
    private int[] minimax(char[][] gameField, char playerSymbol, int depth) {
        if (checkWin(gameField, symbol)) {
            return new int[]{-1, -1, 10};
        }
        if (checkWin(gameField, getOpponentSymbol(symbol))) {
            return new int[]{-1, -1, -10};
        }
        if (!isMovesLeft(gameField)) {
            return new int[]{-1, -1, 0};
        }

        int bestScore = (playerSymbol == symbol) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int[] bestMove = new int[]{-1, -1};

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (gameField[row][col] == ' ') {
                    // Make the move for the current player (playerSymbol)
                    gameField[row][col] = playerSymbol;

                    // Recursively call minimax for the opponent
                    int score = minimax(gameField, getOpponentSymbol(playerSymbol), depth + 1)[2];

                    // Undo the move
                    gameField[row][col] = ' ';

                    // Update the best move and best score
                    if ((playerSymbol == symbol && score > bestScore) ||
                            (playerSymbol != symbol && score < bestScore)) {
                        bestScore = score;
                        bestMove[0] = row;
                        bestMove[1] = col;
                    }
                }
            }
        }

        return new int[]{bestMove[0], bestMove[1], bestScore};
    }

    // checkWin: Checks if there is a winner on the game board
    private boolean checkWin(char[][] gameField, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] == symbol && gameField[i][1] == symbol && gameField[i][2] == symbol) {
                return true;
            }
            if (gameField[0][i] == symbol && gameField[1][i] == symbol && gameField[2][i] == symbol) {
                return true;
            }
        }
        if (gameField[0][0] == symbol && gameField[1][1] == symbol && gameField[2][2] == symbol) {
            return true;
        }
        return gameField[0][2] == symbol && gameField[1][1] == symbol && gameField[2][0] == symbol;
    }
}
