package com.leetcode169.week18;

import java.util.Arrays;

/**
 * Solution for finding the longest increasing path in a matrix.
 * Given an m x n integers matrix, returns the length of the longest increasing path.
 * From each cell, you can move in four directions: left, right, up, or down.
 * You may not move diagonally or outside the boundary.
 */
public class LongestIncreasingPathMatrix {
    /**
     * Finds the longest increasing path in the matrix.
     * Uses DFS with memoization to explore all possible paths from each cell.
     *
     * @param matrix the input matrix of integers
     * @return the length of the longest increasing path
     */
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;

        if(matrix == null || matrix.length ==0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] mem = new int[m][n];
        for(int i =0;i<m;i++){
            Arrays.fill(mem[i], -1);
        }

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                int path = dfs(matrix, i, j, mem);
                max = Math.max(max, path);
            }
        }

        return max;
        
    }

    /**
     * Performs depth-first search to find the longest increasing path starting from cell (i, j).
     * Uses memoization to cache results and avoid redundant calculations.
     *
     * @param matrix the input matrix
     * @param i the row index of the current cell
     * @param j the column index of the current cell
     * @param mem the memoization array storing longest path from each cell
     * @return the length of the longest increasing path from cell (i, j)
     */
    public int dfs(int[][] matrix, int i, int j, int[][] mem){
        if(mem[i][j]!= -1){
            return mem[i][j];
        }

        int[][] dir = {{1,0} , {-1,0}, {0,1} , {0,-1}};
        int m = matrix.length;
        int n = matrix[0].length;
        int max =0;


        for(int[] d: dir){
            int x = i+d[0];
            int y = j+d[1];
            if(x>=0 && x<m && y>=0 && y<n && matrix[x][y]> matrix[i][j]){
                max = Math.max(max, dfs(matrix, x, y, mem));
            }
        }

        return mem[i][j] = max+1;
    }
}
