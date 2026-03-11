package com.otherProblems.dp;

public class MinFallingPathSum {
    /**
     * Calculates the minimum sum of a falling path through a square matrix.
     * A falling path starts at any element in the first row and chooses one element from each row,
     * moving to the next row by choosing the element directly below or diagonally left/right.
     *
     * @param matrix The input square matrix of integers.
     * @return The minimum sum of a falling path from the top to the bottom of the matrix.
     */
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }


        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int leftDiagonal = j > 0 ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int rightDiagonal = j < n-1 ? dp[i-1][j+1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(leftDiagonal, rightDiagonal));
            }
        }

        for(int i = 0; i < n; i++) {
            min = Math.min(min, dp[n-1][i]);
        }

        return min;
    }
}
