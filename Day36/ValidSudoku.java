// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.
 

// Example 1:


// Input: board = 
// [["5","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: true
// Example 2:

// Input: board = 
// [["8","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: false
// Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

// Constraints:

// board.length == 9
// board[i].length == 9
// board[i][j] is a digit 1-9 or '.'.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i) || !isValidSubgrid(board, i / 3 * 3, i % 3 * 3)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < 9; i++) {
            char current = board[row][i];
            if (current != '.') {
                int digit = current - '1';
                if (seen[digit]) {
                    return false;
                }
                seen[digit] = true;
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int col) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < 9; i++) {
            char current = board[i][col];
            if (current != '.') {
                int digit = current - '1';
                if (seen[digit]) {
                    return false;
                }
                seen[digit] = true;
            }
        }
        return true;
    }

    private boolean isValidSubgrid(char[][] board, int startRow, int startCol) {
        boolean[] seen = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char current = board[startRow + i][startCol + j];
                if (current != '.') {
                    int digit = current - '1';
                    if (seen[digit]) {
                        return false;
                    }
                    seen[digit] = true;
                }
            }
        }
        return true;
    }
}
