/**
 * Solution for the Partition Equal Subset Sum problem.
 * 
 * This class determines if a given array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 * 
 * The solution uses dynamic programming with memoization to efficiently
 * check if a subset with sum equal to half of the total sum exists.
 * 
 * Time Complexity: O(n * sum/2) where n is the length of the array
 * Space Complexity: O(n * sum/2) for the memoization table
 */

/**
 * Determines if the array can be partitioned into two subsets with equal sum.
 * 
 * @param nums the input array of positive integers
 * @return true if the array can be partitioned into two equal sum subsets, false otherwise
 */

/**
 * Helper method that recursively checks if a subset with the given target sum can be formed.
 * Uses memoization to avoid redundant calculations.
 * 
 * @param index the current index in the array being considered
 * @param nums the input array of positive integers
 * @param target the remaining sum needed to form a valid subset
 * @param memo memoization table to store previously computed results
 * @return true if a subset with the target sum can be formed from elements at index or before, false otherwise
 */
package com.leetcode169.week7;

public class PartitionEqualSum {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for(int num: nums){
            totalSum += num;
        }

        if(totalSum %2 != 0){
            return false;
        }

        int target = totalSum /2;
        Boolean[][] memo = new Boolean[nums.length+1][target +1];
        
        return partitionHelper(nums.length -1, nums, target, memo);
    }

    public boolean partitionHelper(int index, int[] nums, int target, Boolean[][] memo){
        if(target == 0){
            memo[index][target] = true;
            return true;
        }

        if(target < 0 || index < 0){
            return false;
        }

        if(memo[index][target] != null){
            return memo[index][target];
        }

        boolean take = partitionHelper(index-1, nums, target-nums[index], memo);
        boolean not_take = partitionHelper(index-1, nums, target, memo);

        return memo[index][target] = take || not_take;
    }
}
