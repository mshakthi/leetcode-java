package com.leetcode169.week12;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;    
    }


    /**
     * Generates all valid combinations of parentheses using backtracking.
     * 
     * This method recursively builds valid parentheses strings by exploring all possible
     * combinations while maintaining the constraint that at any point, the number of
     * closing parentheses should not exceed the number of opening parentheses.
     * 
     * @param result the list to store all valid parentheses combinations
     * @param current the current string being built during the recursive process
     * @param open the number of opening parentheses '(' added so far
     * @param close the number of closing parentheses ')' added so far
     * @param max the maximum number of pairs of parentheses to generate
     * 
     * @implNote The recursion terminates when the current string length equals max * 2,
     *           indicating a complete valid combination has been formed.
     *           An opening parenthesis is added only if open < max.
     *           A closing parenthesis is added only if close < open (to maintain validity).
     */
    private void backtrack(List<String> result, String current, int open, int close, int max){
        if( current.length() == max *2){
            result.add(current);
            return;
        }

        if(open < max){
            backtrack(result, current + "(", open +1, close, max);
        }

        if(close < open){
            backtrack(result, current + ")", open, close +1, max);
        }
    }
}
