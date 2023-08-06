package tictactoe;

import java.util.Random;
import java.util.Scanner;

// Define the ComputerMediumPlayer class, a subclass of ComputerPlayer, representing a medium level AI player
class ComputerMediumPlayer extends ComputerPlayer {

    private final Random random;

    public ComputerMediumPlayer(char symbol) {
        super(symbol);
        random = new Random();
    }

    // Implementation to make a medium-level move on the game board
    // It tries to win if possible, blocks the opponent from winning, or makes a random move
    @Override
    public void makeMove(char[][] gameField, Scanner scanner) {

        if (!makeVinMoveMedium(gameField)) {
            if (!overlapOpponent(gameField)) {
                makeRandomMove(gameField);
            }
        }
    }


    // makeRandomMove: Makes a random move on the game board
    public void makeRandomMove(char[][] gameField) {
        while (true) {
            int coordinateX = random.nextInt(gameField.length);
            int coordinateY = random.nextInt(gameField[0].length);

            if (gameField[coordinateX][coordinateY] == ' ') {
                gameField[coordinateX][coordinateY] = symbol;
                break;
            }
        }
    }

    // overlapOpponent: Checks if there is a chance for the opponent to win in the next move and block it

    public boolean overlapOpponent(char[][] gameField) {
        for (int row = 0; row < 3; row++) {
            if (gameField[row][0] != symbol && gameField[row][1] != symbol && gameField[row][0] != ' ' && gameField[row][1] != ' ' && gameField[row][2] == ' ') {
                gameField[row][2] = symbol;
                return true;
            } else if (gameField[row][0] != symbol && gameField[row][2] != symbol && gameField[row][0] != ' ' && gameField[row][2] != ' ' && gameField[row][1] == ' ') {
                gameField[row][1] = symbol;
                return true;
            } else if (gameField[row][1] != symbol && gameField[row][2] != symbol && gameField[row][1] != ' ' && gameField[row][2] != ' ' && gameField[row][0] == ' ') {
                gameField[row][0] = symbol;
                return true;
            }
        }

        //check column
        for (int col = 0; col < 3; col++) {
            if (gameField[0][col] != symbol && gameField[1][col] != symbol && gameField[0][col] != ' ' && gameField[1][col] != ' ' && gameField[2][col] == ' ') {
                gameField[2][col] = symbol;
                return true;
            } else if (gameField[0][col] != symbol && gameField[2][col] != symbol && gameField[0][col] != ' ' && gameField[2][col] != ' ' && gameField[1][col] == ' ') {
                gameField[1][col] = symbol;
                return true;
            } else if (gameField[1][col] != symbol && gameField[2][col] != symbol && gameField[1][col] != ' ' && gameField[2][col] != ' ' && gameField[0][col] == ' ') {
                gameField[0][col] = symbol;
                return true;
            }
        }

        // check diagonal
        if (gameField[0][0] != symbol && gameField[1][1] != symbol && gameField[0][0] != ' ' && gameField[1][1] != ' ' && gameField[2][2] == ' ') {
            gameField[2][2] = symbol;
            return true;
        } else if (gameField[0][0] != symbol && gameField[2][2] != symbol && gameField[0][0] != ' ' && gameField[2][2] != ' ' && gameField[1][1] == ' ') {
            gameField[1][1] = symbol;
            return true;
        } else if (gameField[1][1] != symbol && gameField[2][2] != symbol && gameField[1][1] != ' ' && gameField[2][2] != ' ' && gameField[0][0] == ' ') {
            gameField[0][0] = symbol;
            return true;
        } else if (gameField[2][0] != symbol && gameField[1][1] != symbol && gameField[2][0] != ' ' && gameField[1][1] != ' ' && gameField[0][2] == ' ') {
            gameField[0][2] = symbol;
            return true;
        } else if (gameField[2][0] != symbol && gameField[0][2] != symbol && gameField[2][0] != ' ' && gameField[0][2] != ' ' && gameField[1][1] == ' ') {
            gameField[1][1] = symbol;
            return true;
        } else if (gameField[1][1] != symbol && gameField[0][2] != symbol && gameField[1][1] != ' ' && gameField[0][2] != ' ' && gameField[2][0] == ' ') {
            gameField[2][0] = symbol;
            return true;
        }
        return false;
    }

    // makeVinMoveMedium: Checks if the player can win in the next move and makes that move

    public boolean makeVinMoveMedium(char[][] gameField) {
        for (int row = 0; row < 3; row++) {
            if (gameField[row][0] == symbol && gameField[row][1] == symbol && gameField[row][2] == ' ') {
                gameField[row][2] = symbol;
                return true;
            } else if (gameField[row][0] == symbol && gameField[row][2] == symbol && gameField[row][1] == ' ') {
                gameField[row][1] = symbol;
                return true;
            } else if (gameField[row][1] == symbol && gameField[row][2] == symbol && gameField[row][0] == ' ') {
                gameField[row][0] = symbol;
                return true;
            }
        }

        //check column
        for (int col = 0; col < 3; col++) {
            if (gameField[0][col] == symbol && gameField[1][col] == symbol && gameField[2][col] == ' ') {
                gameField[2][col] = symbol;
                return true;
            } else if (gameField[0][col] == symbol && gameField[2][col] == symbol && gameField[1][col] == ' ') {
                gameField[1][col] = symbol;
                return true;
            } else if (gameField[1][col] == symbol && gameField[2][col] == symbol && gameField[0][col] == ' ') {
                gameField[0][col] = symbol;
                return true;
            }
        }

        // check diagonal
        if (gameField[0][0] == symbol && gameField[1][1] == symbol && gameField[2][2] == ' ') {
            gameField[2][2] = symbol;
            return true;
        } else if (gameField[0][0] == symbol && gameField[2][2] == symbol && gameField[1][1] == ' ') {
            gameField[1][1] = symbol;
            return true;
        } else if (gameField[1][1] == symbol && gameField[2][2] == symbol && gameField[0][0] == ' ') {
            gameField[0][0] = symbol;
            return true;
        } else if (gameField[2][0] == symbol && gameField[1][1] == symbol && gameField[0][2] == ' ') {
            gameField[0][2] = symbol;
            return true;
        } else if (gameField[2][0] == symbol && gameField[0][2] == symbol && gameField[1][1] == ' ') {
            gameField[1][1] = symbol;
            return true;
        } else if (gameField[1][1] == symbol && gameField[0][2] == symbol && gameField[2][0] == ' ') {
            gameField[2][0] = symbol;
            return true;
        }
        return false;
    }

}
