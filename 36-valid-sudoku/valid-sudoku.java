class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValid(board[i])) {
                return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            char[] column = new char[9];
            for (int i = 0; i < 9; i++) {
                column[i] = board[i][j];
            }
            if (!isValid(column)) {
                return false;
            }
        }

        
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                char[] subBox = new char[9];
                int index = 0;
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        subBox[index++] = board[row][col];
                    }
                }
                if (!isValid(subBox)) {
                    return false;
                }
            }
        }

        return true; 
    }

    private boolean isValid(char[] values) {
        boolean[] seen = new boolean[9];
        for (char value : values) {
            if (value != '.') {
                int digit = value - '1';
                if (seen[digit]) {
                    return false; 
                }
                seen[digit] = true;
            }
        }
        return true; 
    }
}
