// Wuihee 
// 10/06/2023
// CSE 123 
// C0: Abstract Strategy Game
// TA: Heon Jwa

// Player class that makes moves for an AbstractStrategyGame.
public class Player {
    
    // Fields
    private String token;
    private int id;

    /**
     * Constructor for a player class which initializes its token and ID.
     * 
     * @param token The token which the player will use, e.g. "X".
     * @param id The ID of the player, e.g. Player 1, Player 2, etc.
     */
    public Player(String token, int id) {
        this.token = token;
        this.id = id;
    }

    /**
     * Places a token on the board for the selected column.
     * 
     * @param userInput The column which the token should be placed.
     * @param board The board which to place the token on.
     */
    public void makeMove(int column, Board board) {
        board.placeToken(token, column);
    }

    /**
     * Retrieves the ID of the player.
     * 
     * @return Player's ID.
     */
    public int getID() {
        return id;
    }
}
