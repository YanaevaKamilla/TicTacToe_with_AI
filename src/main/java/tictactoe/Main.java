package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int n = 3;
    private static final int m = 3;
    private static final char xChar = 'X';
    private static final char oChar = 'O';
    protected static char[][] gameField;
    private static char winnerChar;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input command: ");
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("exit")) {
                break;
            } else if (command.length < 3) {
                System.out.println("Bad parameters!");
            } else if (command[0].equals("start") &&
                    (command[1].equals("user") || command[2].equals("medium")) ||
                    (command[1].equals("medium") && command[2].equals("user")) ||
                    (command[1].equals("user") || command[2].equals("easy")) ||
                    (command[1].equals("easy") && command[2].equals("user")) ||
                    (command[1].equals("easy") || command[2].equals("medium")) ||
                    (command[1].equals("medium") && command[2].equals("easy")) ||
                    (command[1].equals("hard") && command[2].equals("user")) ||
                    (command[1].equals("hard") && command[2].equals("easy")) ||
                    (command[1].equals("hard") && command[2].equals("medium")) ||
                    (command[1].equals("user") && command[2].equals("hard")) ||
                    (command[1].equals("easy") && command[2].equals("hard")) ||
                    (command[1].equals("medium") && command[2].equals("hard")) ||
                    (command[1].equals("hard") && command[2].equals("hard"))) {
                String player1 = command[1];
                String player2 = command[2];
                playGame(player1, player2);
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }

    private static void playGame(String player1, String player2) {
        createGameField();
        Player playerOne = getPlayer(player1, xChar);
        Player playerTwo = getPlayer(player2, oChar);
        boolean player1Turn = true;

        while (true) {
            printGameField(gameField);
            if (checkWhoWins(gameField)) {
                break;
            }
            if (isBoardFull(gameField)) {
                System.out.println("Draw");
                break;
            }

            if (player1Turn) {
                if (playerOne instanceof UserPlayer) {
                    playerOne.makeMove(gameField, scanner);
                } else if (playerOne instanceof ComputerEasyPlayer) {
                    System.out.println("Making move level \"easy\"");
                    playerOne.makeMove(gameField, scanner);
                } else if (playerOne instanceof ComputerMediumPlayer) {
                    System.out.println("Making move level \"medium\"");
                    playerOne.makeMove(gameField, scanner);
                } else {
                    System.out.println("Making move level \"hard\"");
                    playerOne.makeMove(gameField, scanner);
                }
            } else {
                if (playerTwo instanceof UserPlayer) {
                    playerTwo.makeMove(gameField, scanner);
                } else if (playerTwo instanceof ComputerEasyPlayer) {
                    System.out.println("Making move level \"easy\"");
                    playerTwo.makeMove(gameField, scanner);
                } else if (playerTwo instanceof ComputerMediumPlayer) {
                    System.out.println("Making move level \"medium\"");
                    playerTwo.makeMove(gameField, scanner);
                } else {
                    System.out.println("Making move level \"hard\"");
                    playerTwo.makeMove(gameField, scanner);
                }
            }
            player1Turn = !player1Turn;
        }
        System.out.println(winnerChar + " wins\n");
    }

    private static void createGameField() {
        gameField = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                gameField[i][j] = ' ';
            }
        }
    }

    private static void printGameField(char[][] gameField) {
        System.out.println("---------");
        for (int i = 0; i < n; i++) {
            System.out.print("| ");
            for (int j = 0; j < m; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println("| ");
        }
        System.out.println("---------");
    }

    private static Player getPlayer(String playerType, char symbol) {
        return switch (playerType) {
            case "user" -> new UserPlayer(symbol);
            case "easy" -> new ComputerEasyPlayer(symbol);
            case "medium" -> new ComputerMediumPlayer(symbol);
            default -> new ComputerHardPlayer(symbol);
        };
    }

    private static boolean checkWhoWins(char[][] gameField) {
        if (gameField[0][0] == gameField[0][1] && gameField[0][0] == gameField[0][2] && gameField[0][0] != ' ') {
            winnerChar = gameField[0][0];
            return true;
        } else if (gameField[0][0] == gameField[1][0] && gameField[0][0] == gameField[2][0] && gameField[0][0] != ' ') {
            winnerChar = gameField[0][0];
            return true;
        } else if (gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2] && gameField[0][0] != ' ') {
            winnerChar = gameField[0][0];
            return true;
        } else if (gameField[2][2] == gameField[1][2] && gameField[2][2] == gameField[0][2] && gameField[2][2] != ' ') {
            winnerChar = gameField[2][2];
            return true;
        } else if (gameField[2][2] == gameField[2][1] && gameField[2][2] == gameField[2][0] && gameField[2][2] != ' ') {
            winnerChar = gameField[2][2];
            return true;
        } else if (gameField[2][0] == gameField[1][1] && gameField[2][0] == gameField[0][2] && gameField[2][0] != ' ') {
            winnerChar = gameField[2][0];
            return true;
        } else if (gameField[0][1] == gameField[1][1] && gameField[0][1] == gameField[2][1] && gameField[0][1] != ' ') {
            winnerChar = gameField[0][1];
            return true;
        } else if (gameField[1][0] == gameField[1][1] && gameField[1][0] == gameField[1][2] && gameField[1][0] != ' ') {
            winnerChar = gameField[1][0];
            return true;
        } else {
            return false;
        }
    }

    private static boolean isBoardFull(char[][] gameField) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameField[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}