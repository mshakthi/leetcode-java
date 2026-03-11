package com.otherProblems.dp;

public class CherryPickupII {
    /**
     * Calculates the maximum number of cherries that can be collected in a grid.
     * Two robots start at the top row and move to the bottom row, collecting cherries.
     * Each robot can move to the left, right, or stay in the same column in the next row.
     *
     * @param grid The input grid of integers representing cherries.
     * @return The maximum number of cherries that can be collected.
     */
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                dp[n-1][i][j] = grid[n-1][i] + (i == j ? 0 : grid[n-1][j]);
            }
        }


        for(int i = n-2; i >= 0; i--) {
            for(int j1 = 0; j1 < m; j1++) {
                for(int j2 = 0; j2 < m; j2++) {
                    int maxCherries = 0;
                    for(int dj1 = -1; dj1 <= 1; dj1++) {
                        for(int dj2 = -1; dj2 <= 1; dj2++) {
                            int newJ1 = j1 + dj1;
                            int newJ2 = j2 + dj2;
                            if(newJ1 >= 0 && newJ1 < m && newJ2 >= 0 && newJ2 < m) {
                                maxCherries = Math.max(maxCherries, dp[i+1][newJ1][newJ2]);
                            }
                        }
                    }
                    dp[i][j1][j2] = grid[i][j1] + (j1 == j2 ? 0 : grid[i][j2]) + maxCherries;
                }
            }
        }
        
        return dp[0][0][m-1];
       
    }
}