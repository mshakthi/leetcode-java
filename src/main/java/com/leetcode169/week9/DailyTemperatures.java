package com.leetcode169.week9;

import java.util.Stack;

public class DailyTemperatures {
    /**
     * Calculates the number of days until a warmer temperature for each day.
     * 
     * This method uses a monotonic decreasing stack to efficiently find the next warmer temperature.
     * For each day, it determines how many days in the future will have a higher temperature.
     * If no warmer day exists, the result for that day is 0.
     * 
     * Algorithm:
     * - Iterates through temperatures array
     * - Maintains a stack of indices where temperatures are in decreasing order
     * - When a warmer temperature is found, pops indices from stack and calculates
     *   the number of days between current index and popped index
     * - Pushes current index onto stack
     * 
     * Time Complexity: O(n) where n is the length of temperatures array
     * Space Complexity: O(n) for the stack and result array
     * 
     * @param temperatures an array of daily temperatures
     * @return an array where result[i] represents the number of days until a warmer temperature
     *         after day i, or 0 if no warmer day exists
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[temperatures.length];

        for(int i =0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i]> temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            stack.push(i);
        }

        return result;
        
    }
}
