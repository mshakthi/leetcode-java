package com.leetcode169.week20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution for the N-Queens problem.
 * Finds all distinct solutions to place N queens on an N×N chessboard
 * such that no two queens threaten each other.
 */
public class NQueens {
    /**
     * Solves the N-Queens problem using backtracking.
     *
     * @param n the size of the chessboard (number of queens to place)
     * @return a list of all valid board configurations represented as strings,
     *         where 'Q' represents a queen and '.' represents an empty space
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(board[i], '.');
        }
        backtrack(result, board, 0, n);
        return result;
        
    }

    public void backtrack(List<List<String>> result, char[][] board, int row, int n) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] charArray : board) {
                solution.add(new String(charArray));
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(result, board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
