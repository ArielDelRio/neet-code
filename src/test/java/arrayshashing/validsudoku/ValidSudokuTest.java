package arrayshashing.validsudoku;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidSudokuTest {
    @Test
    void example1_validBoard_returnsTrue() {
        char[][] board = {
            {'1','2','.','.','3','.','.','.','.'},
            {'4','.','.','5','.','.','.','.','.'},
            {'.','9','8','.','.','.','.','.','3'},
            {'5','.','.','.','6','.','.','.','4'},
            {'.','.','.','8','.','3','.','.','5'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','.','.','.','.','.','2','.','.'},
            {'.','.','.','4','1','9','.','.','8'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        assertTrue(new ValidSudoku().isValidSudoku(board));
    }

    @Test
    void example2_invalidSubBox_returnsFalse() {
        char[][] board = {
            {'1','2','.','.','3','.','.','.','.'},
            {'4','.','.','5','.','.','.','.','.'},
            {'.','9','1','.','.','.','.','.','3'},
            {'5','.','.','.','6','.','.','.','4'},
            {'.','.','.','8','.','3','.','.','5'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','.','.','.','.','.','2','.','.'},
            {'.','.','.','4','1','9','.','.','8'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        assertFalse(new ValidSudoku().isValidSudoku(board));
    }

    @Test
    void emptyBoard_returnsTrue() {
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = '.';
            }
        }
        assertTrue(new ValidSudoku().isValidSudoku(board));
    }

    @Test
    void duplicateInRow_returnsFalse() {
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = '.';
            }
        }
        board[0][0] = '5';
        board[0][1] = '5';
        assertFalse(new ValidSudoku().isValidSudoku(board));
    }

    @Test
    void duplicateInColumn_returnsFalse() {
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = '.';
            }
        }
        board[0][0] = '7';
        board[1][0] = '7';
        assertFalse(new ValidSudoku().isValidSudoku(board));
    }

    @Test
    void duplicateInSubBox_returnsFalse() {
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = '.';
            }
        }
        board[0][0] = '9';
        board[1][1] = '9';
        assertFalse(new ValidSudoku().isValidSudoku(board));
    }
}
