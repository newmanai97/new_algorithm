package leetCode.question;

public class leetCode37 {

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][]board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char c = '1'; c <= '9'; c++) {
                    if (isValidSudoku(i,j,c,board)) {
                        board[i][j] = c;
                        if(backtracking(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValidSudoku(int row, int col, char val, char[][] board){
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }

        for(int j=0;j<9;j++){
            if (board[j][col] == val) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
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
