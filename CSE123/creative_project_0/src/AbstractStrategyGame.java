// Wuihee 
// 10/06/2023
// CSE 123 
// C0: Abstract Strategy Game
// TA: Heon Jwa

import java.util.*;

/**
 * An interface defining the expected behavior for an abstract strategy game, which is
 * characterized by having perfect information and lacking randomness.
 */
interface AbstractStrategyGame {

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
    public String instructions();

    /**
     * Generates a String representation of the current game state.
     * 
     * The representation will include all player-relevant information including:
     * - The board state.
     * - The scores.
     * 
     * @return A String reflecting the current game state.
     */
    public String toString();

    /**
     * Check if the game is over.
     * 
     * @return true if the game is over, false otherwise.
     */
    public boolean isGameOver();

    /**
     * Identifies the winner of the game.
     * 
     * @return The index of the winner, or -1 if the game is still in progress.
     */
    public int getWinner();

    /**
     * Determines which player is next to make a move.
     * 
     * @return The index of the next player, or -1 if the game has ended.
     */
    public int getNextPlayer();

    /**
     * Executes a move based on the player's input.
     * 
     * @param input A Scanner object to read the player's move.
     * @throws IllegalArgumentException If the move is illegal or invalid.
     */
    public void makeMove(Scanner input);
}
