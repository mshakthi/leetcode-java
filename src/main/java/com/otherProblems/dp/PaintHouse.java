package com.otherProblems.dp;

public class PaintHouse {
    /**
     * Calculates the minimum cost to paint houses such that no two adjacent houses have the same color.
     *
     * @param costs A 2D array where costs[i][j] represents the cost of painting the i-th house with color j.
     *              The colors are represented as indices: 0 for red, 1 for green, and 2 for blue.
     * @return The minimum cost to paint all houses.
     *         Returns 0 if the input array is null or empty.
     */
    public int minCost(int[][] costs) {
            if(costs == null || costs.length == 0) return 0;
            int n = costs.length;
            
            int[][] dp = new int[n][3];
            dp[0][0] = costs[0][0];
            dp[0][1] = costs[0][1];
            dp[0][2] = costs[0][2];

            for(int i = 1; i < n; i++) {
                dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
            }
        
            return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}
