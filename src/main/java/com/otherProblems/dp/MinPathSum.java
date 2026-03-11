package com.otherProblems.dp;

public abstract class MinPathSum {
    /**
     * Calculates the minimum path sum from the top-left corner to the bottom-right corner of a grid.
     * The path can only move either down or right at any point in time.
     *
     * @param grid A 2D array of integers representing the grid where each cell contains a non-negative integer.
     *             The dimensions of the grid are m x n, where m is the number of rows and n is the number of columns.
     * @return The minimum path sum as an integer.
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m-1][n-1];
        
    }
}
