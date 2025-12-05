package com.leetcode169.week7;

public class UniquePaths {
    /**
     * Calculates the number of unique paths from the top-left corner to the bottom-right corner
     * of an m x n grid, where movement is restricted to either right or down at each step.
     * 
     * This method uses dynamic programming to solve the problem. Each cell in the grid represents
     * the number of unique paths to reach that cell from the starting position (0,0).
     * 
     * Algorithm:
     * - Creates a 2D DP array where dp[i][j] represents the number of unique paths to reach cell (i,j)
     * - Initializes dp[0][0] = 1 as there's one way to stay at the starting position
     * - For each cell, calculates the number of paths as the sum of:
     *   * Paths from the cell above (if exists)
     *   * Paths from the cell to the left (if exists)
     * 
     * Time Complexity: O(m * n) - visits each cell once
     * Space Complexity: O(m * n) - stores DP table
     * 
     * @param m the number of rows in the grid (height)
     * @param n the number of columns in the grid (width)
     * @return the total number of unique paths from top-left (0,0) to bottom-right (m-1, n-1)
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;


        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(i ==0 && j ==0){
                    continue;
                }

                int up = i >0 ? dp[i-1][j] : 0;
                int left = j >0 ? dp[i][j-1] : 0;

                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];
        
    }
}
