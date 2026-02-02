package com.leetcode169.week16;

import java.util.Stack;

/**
 * Solution for LeetCode Problem: Basic Calculator II
 * 
 * Implements a basic calculator that evaluates a simple mathematical expression
 * containing non-negative integers and the operators +, -, *, and /.
 * 
 * Algorithm:
 * - Uses a stack to handle operator precedence
 * - Processes characters left to right
 * - For + and -, pushes numbers to stack (negative for subtraction)
 * - For * and /, immediately evaluates with the last number on stack
 * - Finally sums all numbers in the stack for the result
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) for the stack in worst case
 */
public class BasicCalculatorII {
    
    /**
     * Evaluates a mathematical expression string.
     * 
     * @param s the expression string containing digits, spaces, and operators (+, -, *, /)
     * @return the result of evaluating the expression
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char operator = '+'; // Initialize with '+' for the first number

        int num =0; // Current number being built

        for(int i = 0;i< s.length();i++){
            char curr = s.charAt(i);

            // Build multi-digit numbers
            if(Character.isDigit(curr)){
                num = num * 10 + (curr - '0');
            } 
            
            // Process operator or end of string
            if(!Character.isDigit(curr) && !Character.isWhitespace(curr) || i == s.length() -1){
                if(operator == '+'){
                    stack.push(num);
                } else if(operator == '-'){
                    stack.push(-num);
                } else if(operator == '*'){
                    stack.push(stack.pop() * num);
                } else if(operator == '/'){
                    stack.push(stack.pop() / num);
                }
                operator = curr; // Update operator for next iteration
                num =0; // Reset number
            }
        }

        // Sum all numbers in the stack
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }

        return result;

        
        
    }
}
