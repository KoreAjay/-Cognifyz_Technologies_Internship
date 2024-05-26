package g.a.m.e;

import java.util.Scanner;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static char[][] board = new char[3][3];
    private static char currentPlayer = PLAYER_X;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            initializeBoard();
            boolean gameWon = false;
            boolean gameDraw = false;

            while (!gameWon && !gameDraw) {
                displayBoard();
                playerMove(scanner);
                gameWon = checkWin();
                if (gameWon) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                } else {
                    gameDraw = checkDraw();
                    if (gameDraw) {
                        displayBoard();
                        System.out.println("The game is a draw!");
                    } else {
                        switchPlayer();
                    }
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine().equalsIgnoreCase("yes");

        } while (playAgain);

        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
        currentPlayer = PLAYER_X;
    }

    private static void displayBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----");
            }
        }
    }

    private static void playerMove(Scanner scanner) {
        int row, col;
        boolean validMove;

        do {
            System.out.print("Player " + currentPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            validMove = (row >= 0 && row < 3) && (col >= 0 && col < 3) && (board[row][col] == EMPTY);
            if (!validMove) {
                System.out.println("This move is not valid. Try again.");
            }
        } while (!validMove);

        board[row][col] = currentPlayer;
    }

    private static boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
    }
}
