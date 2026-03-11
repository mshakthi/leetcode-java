package com.otherProblems.dp;

public class CoinChangeII {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n][amount + 1];

            for(int i = 0;i<amount + 1;i++) {
                dp[0][i] = i % coins[0] == 0 ? 1 : 0;
            }

            for(int i = 1;i<n;i++) {
                for(int j = 0;j<amount + 1;j++) {
                    dp[i][j] = dp[i-1][j];
                    if(j >= coins[i]) {
                        dp[i][j] += dp[i][j-coins[i]];
                    }
                }
            }

            return dp[n-1][amount];
    }
}
