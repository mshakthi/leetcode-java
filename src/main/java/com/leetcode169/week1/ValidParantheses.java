package com.leetcode169.week1;

import java.util.HashMap;
import java.util.Stack;

/**
 * ValidParantheses class provides functionality to validate if a string containing
 * only parentheses, brackets, and braces is properly balanced and correctly nested.
 * 
 * <p>This class uses a stack-based approach to ensure that every opening bracket
 * has a corresponding closing bracket in the correct order.</p>
 * 
 * <p>Example valid strings: "()", "()[]{}", "{[]}"</p>
 * <p>Example invalid strings: "(]", "([)]", "((("</p>
 */
public class ValidParantheses {
    private final HashMap<Character, Character> braces = new HashMap<>(){{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(braces.containsKey(c)){
                if(stack.isEmpty() || stack.pop() != braces.get(c)){
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
        
    }
    
}
