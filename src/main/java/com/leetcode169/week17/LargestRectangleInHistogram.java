package com.leetcode169.week17;

import java.util.Stack;

public class LargestRectangleInHistogram {
    /**
     * Calculates the largest rectangular area in a histogram.
     * 
     * This method uses a stack-based approach to find the maximum rectangular area
     * that can be formed in a histogram represented by an array of heights.
     * 
     * Algorithm:
     * 1. Uses a monotonic stack to keep track of indices of bars in increasing order of heights
     * 2. When a bar smaller than the stack top is encountered, pop elements and calculate areas
     * 3. For each popped bar, the width is determined by the current index and the index 
     *    of the element below it in the stack
     * 4. After processing all bars, remaining bars in stack are processed similarly
     * 
     * Time Complexity: O(n) where n is the length of heights array, as each element is 
     * pushed and popped at most once
     * 
     * Space Complexity: O(n) for the stack in worst case when heights are in increasing order
     * 
     * @param heights an array of integers representing the heights of histogram bars
     *                where heights[i] is the height of the bar at index i
     * @return the area of the largest rectangle that can be formed in the histogram
     * 
     * @example
     * Input: heights = [2,1,5,6,2,3]
     * Output: 10
     * Explanation: The largest rectangle has height 5 and width 2 (bars at indices 2 and 3)
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Sentinel value to handle empty stack case
        

        for(int i =0;i<n;i++){
            int currentHeight = heights[i];
            while(stack.peek() != -1 && heights[stack.peek()] >= currentHeight){
                int height = heights[stack.pop()];
                int width = i - stack.peek() -1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        while(stack.peek()!=-1){
            int height = heights[stack.pop()];
            int width = n - stack.peek() -1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
        
    }
}
