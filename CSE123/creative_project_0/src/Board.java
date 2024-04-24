// Wuihee 
// 10/06/2023
// CSE 123 
// C0: Abstract Strategy Game
// TA: Heon Jwa

// Class Board represents a 2D board for an AbstractStrategyGame.
public class Board {
    
    // Fields
    private String[][] grid;
    private int[] nextEmptyRow;
    private int rows;
    private int columns;

    /**
     * Constructor to initialize board with a given number of rows and columns.
     * 
     * @param rows Number of rows in the board.
     * @param columns Number of columns in the board.
     */
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new String[rows][columns];
        nextEmptyRow = new int[columns];
        for (int i = 0; i < columns; i++) {
            nextEmptyRow[i] = rows - 1;
        }
    }

    /**
     * Generates a String representation of the current board.
     * 
     * The representation will include all player-relevant information including:
     * - The board state.
     * - The scores.
     * 
     * @return A String reflecting the current game state.
     */
    public String displayBoard() {
        String boardString = "";

        for (int i = 0; i < rows; i++) {
            String[] currentRow = grid[i];
            String currentRowString = Integer.toString(rows - i) + " |";

            for (String cell : currentRow) {
                if (cell == null) {
                    currentRowString += "  ";
                } else {
                    currentRowString += cell + " ";
                }
            }
            boardString += currentRowString + "\n";
        }

        boardString += "   -------------\n";
        boardString += "   1 2 3 4 5 6 7\n";

        return boardString;
    }

    /**
     * Place token on the selected column.
     * 
     * @param token The token to be placed.
     * @param column The column for the token to be placed.
     * @throws IllegalArgumentException If the column is filled or out of bounds.
     */
    public void placeToken(String token, int column) {
        if (column < 0 || column >= columns) {
            throw new IllegalArgumentException("Column is out of bounds!\n");
        }
        if (nextEmptyRow[column] == -1) {
            throw new IllegalArgumentException("This column is full!\n");
        }

        grid[nextEmptyRow[column]][column] = token;
        nextEmptyRow[column]--;
    }

    /**
     * Check if the board is completely filled.
     * 
     * @return true if the board is filled and false otherwise.
     */
    public boolean isFilled() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Utility method for retrieving the specified cell in the board.
     * 
     * @param row The given row.
     * @param column The given columns.
     * @throws IllegalArgumentException if row or column out of bounds.
     * @return The contents of the cell.
     */
    public String getCell(int row, int column) {
        if (row < 0 || row > rows) {
            throw new IllegalArgumentException("Row out of bounds.");
        }
        if (column < 0 || column > columns) {
            throw new IllegalArgumentException("Column out of bounds.");
        }
        return grid[row][column];
    }

    /**
     * Utility method to retrieve the number of rows in the board.
     * 
     * @return Number of rows in the board.
     */
    public int getRows() {
        return rows;
    }
    
    /**
     * Utility method to retrieve the number of columns in the board.
     * 
     * @return Number of columns in the board.
     */
    public int getColumns() {
        return columns;
    }
}

