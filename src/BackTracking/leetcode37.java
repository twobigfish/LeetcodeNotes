package BackTracking;

/**
 * @author: Dayuu
 * @description: 解数独
 */
public class leetcode37 {
    public void solveSudoku(char[][] board) {
        backtraking(board);
    }

    public boolean backtraking(char[][] board) {
        //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！」
        for (int i = 0; i < 9; i++) { // 遍历行
            for (int j = 0; j < 9; j++) { // 遍历列
                if (board[i][j] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) { // (i,j) 这个位置放k是否合适
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;
                        if (backtraking(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }

                // 9个数都试完了，都不行，那么就返回false
                return false;
            }
        }
        return true;
    }

    public boolean isValid(int row, int col, char val, char[][] board) {
        // 同行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }

        // 同列是否重复
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }

        // 九宫格里是否重复
        int startRow = (row / 3) * 3; // (row / 3)获取一行中的第几个九宫格  *3获取第(row / 3)个九宫格的行的开始位置
        int startCol = (col / 3) * 3; //
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
