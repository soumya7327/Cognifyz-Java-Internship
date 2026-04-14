package Level2;

import java.util.Scanner;

public class TicTacToeGame {
    static char[] board = {'1','2','3','4','5','6','7','8','9'};
    static int currentPlayer = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Tic-Tac-Toe Game ===");
        System.out.print("Player 1 enter your name: ");
        String player1 = scanner.nextLine();
        System.out.print("Player 2 enter your name: ");
        String player2 = scanner.nextLine();

        boolean playAgain = true;

        while (playAgain) {
        
            board = new char[]{'1','2','3','4','5','6','7','8','9'};
            currentPlayer = 1;
            boolean gameOver = false;

            while (!gameOver) {
                displayBoard();

                String currentName = (currentPlayer == 1) ? player1 : player2;
                char currentSymbol = (currentPlayer == 1) ? 'X' : 'O';

                System.out.print(currentName + " (" + currentSymbol + ") enter position (1-9): ");
                int position = scanner.nextInt();

               
                if (position < 1 || position > 9 || board[position-1] == 'X' || board[position-1] == 'O') {
                    System.out.println("❌ Invalid position! Try again.");
                    continue;
                }

                
                board[position-1] = currentSymbol;

            
                if (checkWin()) {
                    displayBoard();
                    System.out.println("🎉 " + currentName + " wins!");
                    gameOver = true;
                }
                else if (checkDraw()) {
                    displayBoard();
                    System.out.println("🤝 It's a draw!");
                    gameOver = true;
                }
               
                else {
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                }
            }

            System.out.print("\nPlay again? (y/n): ");
            String again = scanner.next();
            scanner.nextLine();
            playAgain = again.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing! 👋");
        scanner.close();
    }

    static void displayBoard() {
        System.out.println("\n " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---|---|---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---|---|---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    // Check win
    static boolean checkWin() {
        // Rows
        if (board[0]==board[1] && board[1]==board[2]) return true;
        if (board[3]==board[4] && board[4]==board[5]) return true;
        if (board[6]==board[7] && board[7]==board[8]) return true;
        // Columns
        if (board[0]==board[3] && board[3]==board[6]) return true;
        if (board[1]==board[4] && board[4]==board[7]) return true;
        if (board[2]==board[5] && board[5]==board[8]) return true;
        // Diagonals
        if (board[0]==board[4] && board[4]==board[8]) return true;
        if (board[2]==board[4] && board[4]==board[6]) return true;
        return false;
    }

   
    static boolean checkDraw() {
        for (char c : board) {
            if (c != 'X' && c != 'O') return false;
        }
        return true;
    }
}
