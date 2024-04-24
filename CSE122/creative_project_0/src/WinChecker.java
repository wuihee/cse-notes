// Wuihee 
// 10/06/2023
// CSE 123 
// C0: Abstract Strategy Game
// TA: Heon Jwa

// Utility class to check for wins in a board of ConnectFour.
public class WinChecker {
    
    // Fields
    private Board board;
    private int winningLength;
    private int rows;
    private int columns;

    /**
     * Initializes WinChecker with a ConnectFour board.
     * 
     * @param board A 2D board of ConnectFour.
     * @param winningLength The number of tokens in a row to achieve a win.
     */
    public WinChecker(Board board, int winningLength) {
        this.board = board;
        this.winningLength = winningLength;
        rows = board.getRows();
        columns = board.getColumns();

    }

    /**
     * Checks the board for any winning formations.
     * 
     * @return if winner is found, otherwise false.
     */
    public boolean isWinnerFound() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (checkHorizontal(i, j) ||
                    checkVertical(i, j) ||
                    checkDiagonal(i, j) ||
                    checkAntiDiagonal(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check for a horizontal win starting at index (r, c).
     * 
     * @param r The row to start searching.
     * @param c The column to start searching.
     * @return true if winning sequence found and false otherwise.
     */
    private boolean checkHorizontal(int r, int c) {
        if (c <= columns - winningLength) {
            for (int i = 1; i < winningLength; i++) {
                String cell = board.getCell(r, c + i);
                String previousCell = board.getCell(r, c + i - 1);
                if (cell == null || previousCell != cell) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Check for a vertical win starting at index (r, c).
     * 
     * @param r The row to start searching.
     * @param c The column to start searching.
     * @return true if winning sequence found and false otherwise.
     */
    private boolean checkVertical(int r, int c) {
        if (r <= rows - winningLength) {
            for (int i = 1; i < winningLength; i++) {
                String cell = board.getCell(r + i, c);
                String previousCell = board.getCell(r + i - 1, c);
                if (cell == null || previousCell != cell) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Check for a diagonal win starting at index (r, c).
     * 
     * @param r The row to start searching.
     * @param c The column to start searching.
     * @return true if winning sequence found and false otherwise.
     */
    private boolean checkDiagonal(int r, int c) {
        if (r >= winningLength - 1 && c <= columns - winningLength) {
            for (int i = 1; i < winningLength; i++) {
                String cell = board.getCell(r - i, c + i);
                String previousCell = board.getCell(r - i + 1, c + i - 1);
                if (cell == null || previousCell != cell) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Check for an anti-diagonal win starting at index (r, c).
     * 
     * @param r The row to start searching.
     * @param c The column to start searching.
     * @return true if winning sequence found and false otherwise.
     */
    private boolean checkAntiDiagonal(int r, int c) {
        if (r >= winningLength - 1 && c >= winningLength - 1) {
            for (int i = 1; i < winningLength; i++) {
                String cell = board.getCell(r - i, c - i);
                String previousCell = board.getCell(r - i + 1, c - i + 1);
                if (cell == null || previousCell != cell) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
