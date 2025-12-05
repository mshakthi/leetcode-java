/**
 * Solution for the House Robber problem.
 * 
 * <p>Given an array of non-negative integers representing the amount of money in each house,
 * determines the maximum amount of money that can be robbed without robbing two adjacent houses.</p>
 * 
 * <p>Uses dynamic programming approach where memo[i] represents the maximum amount that can be
 * robbed from houses 0 to i.</p>
 * 
 * <p>Time Complexity: O(n) where n is the number of houses</p>
 * <p>Space Complexity: O(n) for the memoization array</p>
 */
/**
 * Calculates the maximum amount of money that can be robbed from the houses.
 * 
 * @param nums an array where each element represents the amount of money in each house
 * @return the maximum amount of money that can be robbed without alerting the police
 *         (i.e., without robbing two adjacent houses)
 * @throws ArrayIndexOutOfBoundsException if nums array is empty
 */
package com.leetcode169.week9;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        memo[0] = nums[0];

        for(int i =1;i<nums.length;i++){
            if(i>1){
                memo[i] = Math.max(memo[i-1], memo[i-2] + nums[i]);
                
            } else {
                memo[i] = Math.max(memo[i-1], nums[i]);
            }
        }
        
        return memo[nums.length - 1];
    } 
}
