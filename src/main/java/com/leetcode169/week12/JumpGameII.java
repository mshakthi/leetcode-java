package com.leetcode169.week12;

public class JumpGameII {
    /**
     * Calculates the minimum number of jumps needed to reach the last index of the array.
     * 
     * Uses a greedy approach where at each step, we track the maximum reachable index
     * within the current jump range. When we reach the end of the current jump range,
     * we increment the jump counter and update the range to the maximum reachable position.
     * 
     * @param nums an array of non-negative integers where each element represents the
     *             maximum jump length from that position
     * @return the minimum number of jumps required to reach the last index
     * 
     * @implNote Time Complexity: O(n) where n is the length of the array
     *           Space Complexity: O(1) as only constant extra space is used
     * 
     * @example
     * Input: nums = [2,3,1,1,4]
     * Output: 2
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     */
    public int jump(int[] nums) {
        int maxReach = 0;
        int jumps = 0;
        int currReach =0;

        for(int i =0;i< nums.length-1;i++){
            maxReach = Math.max(maxReach, i + nums[i]);

            if(i == currReach){
                jumps++;
                currReach = maxReach;
            }

        }

        return jumps;
    }
}
