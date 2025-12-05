package com.leetcode169.week2;

public class ClimbingStairs {
    /**
     * Calculates the number of distinct ways to climb a staircase with n steps.
     * At each step, you can either climb 1 or 2 steps.
     * 
     * This method uses dynamic programming with space optimization to solve the problem.
     * The solution is based on the Fibonacci sequence pattern where the number of ways
     * to reach step n equals the sum of ways to reach step (n-1) and step (n-2).
     * 
     * Time Complexity: O(n) - iterates through steps from 3 to n
     * Space Complexity: O(1) - uses only constant extra space
     * 
     * @param n the total number of steps in the staircase (n >= 0)
     * @return the total number of distinct ways to climb to the top
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }


        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
        
    }
}
