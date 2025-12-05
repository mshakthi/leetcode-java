package com.leetcode169.week8;

/**
 * A solution to the Word Search problem where you need to find if a word exists
 * in a 2D board of characters. The word can be constructed from letters of
 * sequentially adjacent cells, where adjacent cells are horizontally or vertically
 * neighboring. The same letter cell may not be used more than once.
 * 
 * <p>Example:
 * <pre>
 * board = [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * word = "ABCCED" -> returns true
 * word = "SEE" -> returns true
 * word = "ABCB" -> returns false
 * </pre>
 * 
 */
public class WordSearch {

    /**
     * Searches for the existence of a word in the given 2D character board.
     * Uses backtracking to explore all possible paths from each cell.
     * 
     * @param board a 2D character array representing the board to search
     * @param word the target word to find in the board
     * @return true if the word exists in the board, false otherwise
     * @throws NullPointerException if board or word is null
     * @throws ArrayIndexOutOfBoundsException if board is empty
     */
public boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;
    boolean[][] visited = new boolean[rows][cols];
    
    for(int r =0; r< rows; r++){
            for(int c =0; c< cols; c++){
                if(backtrack(r, c, board, 0, word, visited)){
                    return true;
                }
            }
        }
        return false;
    }


        /**
     * Performs depth-first search with backtracking to find if the remaining
     * portion of the word can be matched starting from the current cell.
     * 
     * @param row the current row position on the board
     * @param col the current column position on the board
     * @param board the 2D character array representing the board
     * @param index the current index in the word being matched
     * @param word the target word to find
     * @param visited a 2D boolean array tracking which cells have been visited
     *                in the current search path
     * @return true if the word can be formed from this position, false otherwise
     */
    public boolean backtrack(int row, int col, char[][] board, int index, String word, boolean[][] visited){
        if(index == word.length()){
            return true;
        }

        if(row <0 || col <0 || row >= board.length || col >= board[0].length){
            return false;
        }

        if(visited[row][col] || board[row][col] != word.charAt(index)){
            return false;
        }

        visited[row][col] = true;
        boolean found = backtrack(row + 1, col, board, index + 1, word, visited) ||
                        backtrack(row - 1, col, board, index + 1, word, visited) ||
                        backtrack(row, col + 1, board, index + 1, word, visited) ||
                        backtrack(row, col - 1, board, index + 1, word, visited);
        visited[row][col] = false;
        return found;
    }
}
