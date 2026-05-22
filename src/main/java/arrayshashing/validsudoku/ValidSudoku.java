package arrayshashing.validsudoku;

/**
 * Valid Sudoku
 * Medium
 *
 * You are given a 9 x 9 Sudoku board board. A Sudoku board is valid if the
 * following rules are followed:
 *
 * - Each row must contain the digits 1-9 without duplicates.
 * - Each column must contain the digits 1-9 without duplicates.
 * - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
 * without duplicates.
 *
 * Return true if the Sudoku board is valid, otherwise return false
 *
 * Note: A board does not need to be full or be solvable to be valid.
 *
 * Example 1:
 * Input: board =
 * [["1","2",".",".","3",".",".",".","."],
 * ["4",".",".","5",".",".",".",".","."],
 * [".","9","8",".",".",".",".",".","3"],
 * ["5",".",".",".","6",".",".",".","4"],
 * [".",".",".","8",".","3",".",".","5"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".",".",".",".",".",".","2",".","."],
 * [".",".",".","4","1","9",".",".","8"],
 * [".",".",".",".","8",".",".","7","9"]]
 * Output: true
 *
 * Example 2:
 * Input: board =
 * [["1","2",".",".","3",".",".",".","."],
 * ["4",".",".","5",".",".",".",".","."],
 * [".","9","1",".",".",".",".",".","3"],
 * ["5",".",".",".","6",".",".",".","4"],
 * [".",".",".","8",".","3",".",".","5"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".",".",".",".",".",".","2",".","."],
 * [".",".",".","4","1","9",".",".","8"],
 * [".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: There are two 1's in the top-left 3x3 sub-box.
 *
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 */
public class ValidSudoku {
    /**
     * Determines if a given 9x9 Sudoku board is valid.
     *
     * @param board 2D array representing the Sudoku board
     * @return true if the board is valid, false otherwise
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                char current = board[row][col];
                if (current == '.') {
                    continue;
                }

                int numIndex = current - '1'; // Convert char '1'-'9' to index 0-8
                int boxIndex = (row / 3) * 3 + (col / 3);

                // Check if the current number has already been seen in the current row, column, or box
                if (rows[row][numIndex]
                        || cols[col][numIndex]
                        || boxes[boxIndex][numIndex]) {
                    return false;
                }

                // Mark the current number as seen in the current row, column, and box
                rows[row][numIndex] = true;
                cols[col][numIndex] = true;
                boxes[boxIndex][numIndex] = true;
            }
        }
        return true;
    }
}
