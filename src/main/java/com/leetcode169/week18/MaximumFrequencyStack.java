package com.leetcode169.week18;

import java.util.HashMap;
import java.util.Stack;

/**
 * A stack data structure that supports push and pop operations where pop always returns
 * the most frequently pushed element. If there's a tie, the most recently pushed element
 * among the most frequent ones is returned.
 * 
 * <p>Time Complexity:
 * <ul>
 *   <li>push: O(1)</li>
 *   <li>pop: O(1)</li>
 * </ul>
 * 
 * <p>Space Complexity: O(n) where n is the number of elements in the stack
 */
public class MaximumFrequencyStack {
    /** The current maximum frequency of any element in the stack */
    int max_freq;
    
    /** Maps each element to its current frequency count */
    HashMap<Integer, Integer> freq;
    
    /** Maps each frequency level to a stack of elements with that frequency */
    HashMap<Integer, Stack<Integer>> groups;

    /**
     * Constructs an empty MaximumFrequencyStack.
     */
    public MaximumFrequencyStack() {
        freq = new HashMap<>();
        groups = new HashMap<>();
        
    }
    
    /**
     * Pushes a value onto the stack.
     * 
     * @param val the value to push onto the stack
     */
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (f > max_freq) {
            max_freq = f;
        }
        groups.putIfAbsent(f, new Stack<>());
        groups.get(f).push(val);
        
    }
    
    /**
     * Removes and returns the most frequent element in the stack.
     * If there is a tie for most frequent, the most recently pushed element is returned.
     * 
     * @return the most frequent element (or most recent if tied)
     */
    public int pop() {
        Stack<Integer> stack = groups.get(max_freq);
        int val = stack.pop();
        freq.put(val, freq.get(val) - 1);
        if (stack.isEmpty()) {
            max_freq--;
        }
        return val;
        
    }
}
