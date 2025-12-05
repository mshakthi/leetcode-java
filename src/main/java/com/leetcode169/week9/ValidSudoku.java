/**
 * Validates whether a 9x9 Sudoku board is valid according to the following rules:
 * <ul>
 *   <li>Each row must contain the digits 1-9 without repetition.</li>
 *   <li>Each column must contain the digits 1-9 without repetition.</li>
 *   <li>Each of the nine 3x3 sub-boxes must contain the digits 1-9 without repetition.</li>
 * </ul>
 * 
 * Note: A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * Empty cells are represented by the '.' character.
 *
 * @param board a 9x9 2D character array representing the Sudoku board
 * @return true if the board is valid, false otherwise
 * 
 * Time Complexity: O(1) - always processes a fixed 9x9 board (81 cells)
 * Space Complexity: O(1) - uses three fixed-size 9x9 boolean arrays
 */
package com.leetcode169.week9;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][9];
        boolean[][] colCheck = new boolean[9][9];
        boolean[][] boxCheck = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j]!= '.'){
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    if(rowCheck[i][num] || colCheck[j][num] || boxCheck[boxIndex][num]){
                        return false;
                    }

                    rowCheck[i][num] = true;
                    colCheck[j][num] = true;
                    boxCheck[boxIndex][num] = true;
                }
            }
        }
        return true;
        
    }
    
}
