package com.otherProblems.dp;

public class LongestCommonSubSequnce {
    /**
     * Calculates the length of the longest common subsequence between two strings.
     * 
     * This method uses dynamic programming to find the longest subsequence present in both strings.
     * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
     * 
     * Algorithm:
     * - Creates a 2D DP table where dp[i][j] represents the length of LCS of text1[0..i-1] and text2[0..j-1]
     * - If characters match at position i-1 and j-1, adds 1 to the diagonal value (dp[i-1][j-1])
     * - If characters don't match, takes the maximum of top cell (dp[i-1][j]) or left cell (dp[i][j-1])
     * 
     * Time Complexity: O(n * m) where n is the length of text1 and m is the length of text2
     * Space Complexity: O(n * m) for the DP table
     * 
     * @param text1 the first input string
     * @param text2 the second input string
     * @return the length of the longest common subsequence between text1 and text2
     * 
     * @example
     * longestCommonSubsequence("abcde", "ace") returns 3 (the LCS is "ace")
     * longestCommonSubsequence("abc", "def") returns 0 (no common subsequence)
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
        
    }
}
