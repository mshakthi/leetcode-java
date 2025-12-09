package com.leetcode169.week16;

public class TrappingRainWater {
    /**
     * Calculates the total amount of rainwater that can be trapped between elevation bars.
     * Uses a two-pointer approach to efficiently compute the trapped water.
     * 
     * Algorithm:
     * - Uses two pointers starting from both ends of the array
     * - Tracks the maximum height seen so far from both left and right sides
     * - Moves the pointer with smaller height inward
     * - For each position, water trapped = max height from that side - current height
     * 
     * Time Complexity: O(n) where n is the length of the height array
     * Space Complexity: O(1) as only constant extra space is used
     * 
     * @param height an array of non-negative integers representing the elevation map
     *               where the width of each bar is 1
     * @return the total amount of water that can be trapped after raining
     * 
     * Example:
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The elevation map traps 6 units of rain water
     */
    public int trap(int[] height) {
        int n = height.length;

        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;

        int waterTrapped = 0;

        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    waterTrapped += leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    waterTrapped += rightMax - height[right];
                }
                right--;
            }
                  
        }

        return waterTrapped;
        
    }
}
