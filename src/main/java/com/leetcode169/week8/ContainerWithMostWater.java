package com.leetcode169.week8;

public class ContainerWithMostWater {
    /**
     * Calculates the maximum area of water that can be contained between two vertical lines.
     * Uses the two-pointer approach to find the container with the most water.
     * 
     * Algorithm:
     * - Start with two pointers at the beginning and end of the array
     * - Calculate the area formed between the two lines
     * - Move the pointer pointing to the shorter line inward
     * - Continue until the pointers meet
     * 
     * @param height an array of integers where each element represents the height of a vertical line
     * @return the maximum area of water that can be contained between any two lines
     * 
     * Time Complexity: O(n) where n is the length of the height array
     * Space Complexity: O(1) as only constant extra space is used
     * 
     * @throws NullPointerException if height is null
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length -1;

        while(left<right){
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;
            maxArea = Math.max(maxArea, currentArea);
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
