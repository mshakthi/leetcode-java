package com.otherProblems.dp;

import java.util.List;

public class Triangle {
    /**
     * Calculates the minimum path sum from top to bottom in a triangle.
     * Each step can move to adjacent numbers on the row below.
     *
     * @param triangle A list of lists of integers representing the triangle.
     * @return The minimum path sum from top to bottom.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i = n-2;i>=0;i--) {
            for(int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }
}
