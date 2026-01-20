package com.leetcode169.week18;

import java.util.Stack;

/**
 * Solution for LeetCode problem: Longest Valid Parentheses
 * 
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 */
public class LongestValidParanthesis {
    
    /**
     * Finds the length of the longest valid parentheses substring using a stack-based approach.
     * 
     * Algorithm:
     * - Uses a stack to track indices of characters
     * - Initializes stack with -1 as a base index
     * - For each '(', push its index onto the stack
     * - For each ')', pop from stack:
     *   - If stack becomes empty, push current index (new base)
     *   - Otherwise, calculate length as (current index - top of stack)
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for the stack in worst case
     * 
     * @param s the input string containing only '(' and ')' characters
     * @return the length of the longest valid parentheses substring
     */
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;

        for(int i = 0;i< s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    max = Math.max(max, len);
                }
            }
        }

        return max;
        
    }

    /**
     * Finds the length of the longest valid parentheses substring using a space-optimized two-pass approach.
     * 
     * Algorithm:
     * - First pass (left to right):
     *   - Count open '(' and close ')' parentheses
     *   - When counts are equal, update max length (2 * close)
     *   - When close > open, reset both counters (invalid sequence)
     * - Second pass (right to left):
     *   - Count open '(' and close ')' parentheses in reverse
     *   - When counts are equal, update max length (2 * close)
     *   - When open > close, reset both counters (invalid sequence)
     * 
     * Why two passes?
     * - Left-to-right handles cases where extra ')' breaks the sequence
     * - Right-to-left handles cases where extra '(' breaks the sequence
     * - Together they cover all valid parentheses patterns
     * 
     * Time Complexity: O(n) where n is the length of the string (two passes)
     * Space Complexity: O(1) - only uses constant extra space
     * 
     * @param s the input string containing only '(' and ')' characters
     * @return the length of the longest valid parentheses substring
     */
    public int longestValidParenthesesWithSpaceOptimization(String s) {
        int open = 0;
        int close = 0;
        int max = 0;

        for(int i = 0;i< s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            } else {
                close++;
            }

            if(open == close){
                max = Math.max(max, 2 * close);
            } else if(close > open){
                open = 0;
                close = 0;
            }
        }

        for(int i = s.length()-1;i >= 0;i--){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            } else {
                close++;
            }

            if(open == close){
                max = Math.max(max, 2 * close);
            } else if(open > close){
                open = 0;
                close = 0;
            }
        }
        return max;
    }
}
