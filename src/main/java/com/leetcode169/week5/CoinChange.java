package com.leetcode169.week5;

import java.util.Arrays;

/**
 * Solution for the Coin Change problem using dynamic programming with memoization.
 * 
 * Given an array of coin denominations and a target amount, this class finds the minimum
 * number of coins needed to make up that amount. If it's not possible to make the amount
 * with the given coins, it returns -1.
 * 
 * Algorithm:
 * - Uses a top-down dynamic programming approach with memoization
 * - For each coin, decides whether to take it or skip it
 * - Recursively explores both options and chooses the minimum
 * 
 * Time Complexity: O(n * amount) where n is the number of coins
 * Space Complexity: O(n * amount) for the memoization table
 * 
 */

/**
 * Finds the minimum number of coins needed to make up the given amount.
 * 
 * @param coins An array of coin denominations available
 * @param amount The target amount to make change for
 * @return The minimum number of coins needed, or -1 if the amount cannot be made
 */

/**
 * Recursive helper function that performs depth-first search with memoization.
 * 
 * @param index The current coin index being considered
 * @param coins The array of coin denominations
 * @param amount The remaining amount to make change for
 * @param memo The memoization table to store computed results
 * @return The minimum number of coins needed for the remaining amount, or Integer.MAX_VALUE if impossible
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for(int i = 0; i < coins.length; i++) {
           Arrays.fill(memo[i], -1);
        }

        int result = dfs(coins.length - 1, coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int dfs(int index, int[] coins, int amount, int[][] memo) {
        if(amount == 0) {
            return 0;
        }

        if(index < 0) {
            return Integer.MAX_VALUE;
        }

        if(memo[index][amount] != -1) {
            return memo[index][amount];
        }

        int notTake = dfs(index - 1, coins, amount, memo);
        int take = Integer.MAX_VALUE;
        if(amount >= coins[index]) {
            int res = dfs(index, coins, amount - coins[index], memo);
            if(res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }

        memo[index][amount] = Math.min(notTake, take);
        return memo[index][amount];
    }
    
}
