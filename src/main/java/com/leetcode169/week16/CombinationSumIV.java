package com.leetcode169.week16;

import java.util.HashMap;

/**
 * Solution for LeetCode Problem 377: Combination Sum IV.
 * 
 * <p>This class finds the number of possible combinations that add up to a target value.
 * Unlike traditional combination problems, different sequences are counted as different combinations.
 * For example, [1,2] and [2,1] are considered different combinations.</p>
 * 
 * <p>The solution uses dynamic programming with memoization to avoid redundant calculations.
 * Time Complexity: O(target * n) where n is the length of nums array.
 * Space Complexity: O(target) for the memoization HashMap and recursion stack.</p>
 * 
 * <p>Example:
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation: The possible combinations are:
 * (1,1,1,1), (1,1,2), (1,2,1), (1,3), (2,1,1), (2,2), (3,1)</p>
 */
public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return buildCombinations(nums, target, memo);
    }

    public int buildCombinations(int[] nums, int target, HashMap<Integer, Integer> memo) {
        if( target == 0) {
            return 1;
        }

        if(memo.containsKey(target)) {
            return memo.get(target);
        }

        for(int num: nums){
            if(target - num >=0){
                int count = memo.getOrDefault(target, 0);
                count += buildCombinations(nums, target - num, memo);
                memo.put(target, count);
            }
        }
        return memo.get(target);
    }


    
}
