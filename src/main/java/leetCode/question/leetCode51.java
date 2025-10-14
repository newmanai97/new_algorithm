package leetCode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetCode51 {
    private List<List<String>> res = new ArrayList<>();


    public List<List<String>> solveNQueens(int n) {
        char[][]  board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtracking(0,n,board);
        return res;
    }

    private void backtracking(int row, int n, char[][] board) {
        if (row == n) {
            res.add(charArrToStrList(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row, i, n, board)) {
                board[row][i] = 'Q';
                backtracking(row + 1, n, board);
                board[row][i] = '.';
            }
        }
    }

    private List<String> charArrToStrList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            list.add(String.valueOf(c));
        }
        return list;
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row-1, j = col+1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
