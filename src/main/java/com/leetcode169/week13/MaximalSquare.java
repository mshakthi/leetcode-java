package com.leetcode169.week13;

public class MaximalSquare {
    /**
     * Finds the area of the largest square containing only '1's in a binary matrix.
     *
     * @param matrix a 2D char array where each element is either '0' or '1'
     * @return the area of the maximal square that can be formed using '1's in the matrix
     *
     * <p><b>Algorithm:</b> Dynamic Programming
     * <ul>
     *   <li>dp[i][j] represents the side length of the largest square with bottom-right corner at (i-1, j-1)</li>
     *   <li>If matrix[i-1][j-1] is '1', then dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1</li>
     *   <li>Track the maximum side length encountered</li>
     *   <li>Return the area as maxSide * maxSide</li>
     * </ul>
     *
     * <p><b>Time Complexity:</b> O(n × m) where n is the number of rows and m is the number of columns
     * <p><b>Space Complexity:</b> O(n × m) for the dp table
     *
     * @example
     * Input: matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]
     * Output: 4 (representing a 2×2 square)
     */
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n+1][m+1];
        int maxSide = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
}
