// Wuihee 
// 10/06/2023
// CSE 123 
// C0: Abstract Strategy Game
// TA: Heon Jwa

import java.util.*;

// ConnectFour implements AbstractStrategyGame and is an implementation of the classic
// Connect Four in the console represented with Strings.
public class ConnectFour implements AbstractStrategyGame{

    // Fields
    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private final int WINNING_LENGTH = 4;
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private WinChecker winChecker;

    /**
     * Constructor that initializes ConnectFour with the gamestate and players.
     */
    public ConnectFour() {
        board = new Board(ROWS, COLUMNS);
        player1 = new Player("X", 1);
        player2 = new Player("O", 2);
        currentPlayer = player1;
        winChecker = new WinChecker(board, WINNING_LENGTH);
    }

    /**
     * Provides instructions on how to play the game.
     * 
     * The instructions include:
     * - The interpretation of the game state, as provided by {@link #toString}.
     * - How to perform moves.
     * - The conditions that determine the end of the game and winning criteria.
     * 
     * @return A String containing instructions on how to play.
     */
    public String instructions() {
        String instructions = """                                                                                  
            #####                                           #######                      
            #     #  ####  #    # #    # ######  ####  ##### #        ####  #    # #####  
            #       #    # ##   # ##   # #      #    #   #   #       #    # #    # #    # 
            #       #    # # #  # # #  # #####  #        #   #####   #    # #    # #    # 
            #       #    # #  # # #  # # #      #        #   #       #    # #    # #####  
            #     # #    # #   ## #   ## #      #    #   #   #       #    # #    # #   #  
             #####   ####  #    # #    # ######  ####    #   #        ####   ####  #    # 
                                                                                          
            Welcome to Connect Four!

            Connect Four is a two-player connection game in which the players take turns dropping
            their tokens into a six-row vertically suspended grid. The pieces fall straight down,
            occupying the next available space within the column. The object of the game is to
            connect four of one's own tokens next to each other vertically, horizontally, or
            diagonally before your opponent.
            
            Here is how the game works:
            - Player 1 selects a column to drop their token into the grid.
            - Player 2 then selects a column to drop their token.
            - Players alternate turns until one player gets four of their discs in a line or
              the grid is filled.
            - If the grid is filled and no player has four discs in a line, the game is a draw.
            
            Instructions for making a move:
            1. The current state of the grid will be displayed. Each column will be numbered.
            2. To make a move, enter the number of the column where you want to drop your disc.
        """;
        return instructions;
    }

    /**
     * Generates a String representation of the current game state.
     * 
     * The representation will include all player-relevant information including:
     * - The board state.
     * - The scores.
     * 
     * @return A String reflecting the current game state.
     */
    public String toString() {
        return board.displayBoard();
    }

    /**
     * Check if the game is over.
     * 
     * @return true if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        if (winChecker.isWinnerFound() || board.isFilled()) {
            return true;
        }
        return false;
    }

    /**
     * Identifies the winner of the game.
     * 
     * @return The index of the winner, or -1 if the game is still in progress.
     */
    public int getWinner() {
        if (winChecker.isWinnerFound()) {
            return currentPlayer.getID();
        } else if (board.isFilled()) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Determines which player is next to make a move.
     * 
     * @return The index of the next player, or -1 if the game has ended.
     */
    public int getNextPlayer() {
        if (isGameOver()) {
            return -1;
        }
        return currentPlayer.getID();
    }

    /**
     * Executes a move based on the player's input.
     * 
     * @param input A Scanner object to read the player's move.
     */
    public void makeMove(Scanner input) {
        int column = getUserInput(input) - 1;  // - 1 because we use 0-indexing.
        currentPlayer.makeMove(column, board);
        if (!isGameOver()) {
            changePlayers();
        }
    };

    /**
     * Utility method for changing between player 1 and 2 after each move.
     */
    private void changePlayers () {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    /**
     * Gets the user input for which column they want to place their token.
     * 
     * @param input Scanner object which extracts the users input.
     * @return Column which user has selected.
     * @throws IllegalArgumentException if user didn't enter an integer.
     */
    private int getUserInput(Scanner input) {
        System.out.print("Choose which column to place your token: ");
        if (!input.hasNextInt()) {
            input.nextLine();  // Advance input to "clear" input.
            throw new IllegalArgumentException("You need to enter a column number.");
        }
        return input.nextInt();
    }
}
