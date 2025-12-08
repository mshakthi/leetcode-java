package com.leetcode169.week13;

import java.util.Stack;

public class AsteroidCollision {
    /**
     * Simulates the collision of asteroids moving in a line.
     * 
     * <p>Asteroids are represented as integers where:
     * <ul>
     *   <li>Positive values represent asteroids moving to the right</li>
     *   <li>Negative values represent asteroids moving to the left</li>
     *   <li>The absolute value represents the size of the asteroid</li>
     * </ul>
     * 
     * <p>When two asteroids collide:
     * <ul>
     *   <li>The smaller one explodes</li>
     *   <li>If both are the same size, both explode</li>
     *   <li>Asteroids moving in the same direction never collide</li>
     * </ul>
     * 
     * @param asteroids an array of integers representing asteroids in a row,
     *                  where positive values move right and negative values move left
     * @return an array of integers representing the state of asteroids after all collisions
     * 
     * @implNote Uses a stack-based approach to efficiently simulate collisions.
     *           Time complexity: O(n), Space complexity: O(n)
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids) {
            if(asteroid > 0) {
                stack.push(asteroid);
            } else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)){
                    stack.pop();
                }

                if(stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if(stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
            }

        }

        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
