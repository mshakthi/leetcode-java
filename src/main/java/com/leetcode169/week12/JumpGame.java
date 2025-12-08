package com.leetcode169.week12;

/**
 * Solution for the Jump Game problem.
 * Given an array of non-negative integers nums where each element represents 
 * the maximum jump length from that position, determines if you can reach 
 * the last index starting from the first index.
 * 
 * Algorithm:
 * - Uses a greedy approach to track the maximum reachable index
 * - Iterates through the array and updates the maximum reachable position
 * - If at any point the current index exceeds the maximum reachable position,
 *   it means we cannot proceed further and return false
 * 
 * Time Complexity: O(n) where n is the length of the input array
 * Space Complexity: O(1) as only a single variable is used for tracking
 * 
 * @see <a href="https://leetcode.com/problems/jump-game/">LeetCode Problem 55</a>
 */
public class JumpGame {
    /**
     * Determines if it's possible to reach the last index of the array.
     * 
     * @param nums an array of non-negative integers where nums[i] represents 
     *             the maximum jump length at position i
     * @return true if the last index can be reached, false otherwise
     * 
     * Example:
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * 
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3. Its maximum jump length is 0,
     * which makes it impossible to reach the last index.
     */
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for(int i =0;i<nums.length;i++){
            if(i> maxReach){
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}
