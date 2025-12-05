/**
 * Evaluates a mathematical expression written in Reverse Polish Notation (RPN).
 * 
 * <p>This class provides functionality to evaluate expressions where operators follow
 * their operands. For example, "3 4 +" represents "3 + 4" in standard notation.
 * 
 * <p>Supported operators: +, -, *, /
 * 
 * <p>Example usage:
 * <pre>
 * EvaluateRPN evaluator = new EvaluateRPN();
 * String[] tokens = {"2", "1", "+", "3", "*"};
 * int result = evaluator.evalRPN(tokens); // Returns 9 (i.e., (2 + 1) * 3)
 * </pre>
 */

/**
 * Evaluates an expression in Reverse Polish Notation.
 * 
 * @param tokens an array of strings representing numbers and operators in RPN format
 * @return the result of evaluating the RPN expression
 * @throws NumberFormatException if a token cannot be parsed as an integer
 * @throws IllegalArgumentException if an invalid operator is encountered
 * @throws java.util.EmptyStackException if the expression is malformed
 */

/**
 * Checks if a given token is a valid operator.
 * 
 * @param token the string to check
 * @return true if the token is one of +, -, *, /; false otherwise
 */

/**
 * Applies a binary operation to two operands.
 * 
 * @param a the first operand (left operand in infix notation)
 * @param b the second operand (right operand in infix notation)
 * @param operator the operator to apply (+, -, *, /)
 * @return the result of applying the operator to the operands
 * @throws IllegalArgumentException if the operator is not recognized
 */
package com.leetcode169.week5;

import java.util.Stack;

public class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens) {
            if(isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperation(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int applyOperation(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}