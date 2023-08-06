package tictactoe;

import java.util.Scanner;

// Define the UserPlayer class, a subclass of Player, representing a human player
class UserPlayer extends Player {
    public UserPlayer(char symbol) {
        super(symbol);
    }

    // Implementation to get the user's move through the console input
    // The user is prompted to enter the coordinates for their move
    @Override
    public void makeMove(char[][] gameField, Scanner scanner) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
                continue;
            }
            int coordinateX = scanner.nextInt() - 1;

            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
                continue;
            }
            int coordinateY = scanner.nextInt() - 1;

            if (coordinateX < 0 || coordinateX >= gameField.length || coordinateY < 0 || coordinateY >= gameField[0].length) {
                System.out.println("Coordinates are out of bounds!");
                scanner.nextLine();
                continue;
            }

            if (gameField[coordinateX][coordinateY] == 'X' || gameField[coordinateX][coordinateY] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
                scanner.nextLine();
                continue;
            }

            gameField[coordinateX][coordinateY] = symbol;
            break;
        }
    }
}
