package com.leetcode169.week17;

/**
 * Basic Calculator implementation that evaluates a string expression containing
 * digits, '+', '-', '(', ')' and spaces.
 * Uses recursive descent parsing to handle parentheses.
 */
public class BasicCalculator {

    /**
     * Calculates the result of a mathematical expression.
     * 
     * @param s the string expression to evaluate
     * @return the computed result as an integer
     */
    public int calculate(String s) {

        char[] chars = s.toCharArray();

        return dfs(chars, new int[]{0});
        
    }

    /**
     * Depth-first search helper method to recursively evaluate the expression.
     * Handles operators (+, -), parentheses, and multi-digit numbers.
     * 
     * @param chars the character array of the expression
     * @param index the current position in the array
     * @return the evaluated result of the sub-expression
     */
    public int dfs(char[] chars, int[] index) {
        int sum = 0;
        int sign = 1;

        while (index[0] < chars.length) {
            if (chars[index[0]] == ' ') {
                index[0]++;
            } else if (chars[index[0]] == ')') {
                index[0]++;
                break;
            } else if (chars[index[0]] == '(') {
                index[0]++;
                sum += sign * dfs(chars, index);
            } else if (chars[index[0]] == '+') {
                sign = 1;
                index[0]++;
            } else if (chars[index[0]] == '-') {
                sign = -1;
                index[0]++;
            } else if (Character.isDigit(chars[index[0]])) {
                int num = 0;
                while (index[0] < chars.length && Character.isDigit(chars[index[0]])) {
                    num = num * 10 + (chars[index[0]] - '0');
                    index[0]++;
                }
                sum += sign * num;
            } else {
                index[0]++;
            }
        }

        return sum;
    }
}
