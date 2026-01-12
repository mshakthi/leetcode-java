package com.leetcode169.week6;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();

            buiildCombinations(0, candidates, target, new ArrayList<>(), result);
            return result;
        
        }

        /**
         * Recursively builds all unique combinations of candidates that sum up to the target value.
         * Uses backtracking to explore two possibilities at each index: including or excluding the current candidate.
         * 
         * @param index the current index in the candidates array being considered
         * @param candidates an array of candidate numbers to form combinations
         * @param target the remaining target sum to achieve
         * @param current the current combination being built
         * @param result the list to store all valid combinations that sum to the original target
         * 
         * Base cases:
         * - If target reaches 0, the current combination is added to the result
         * - If index reaches the end of candidates array or target becomes negative, backtrack
         * 
         * The method explores two branches:
         * 1. Include the current candidate (allowing reuse by keeping the same index)
         * 2. Exclude the current candidate (moving to the next index)
         */
        public void buiildCombinations(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> result){
            if(target == 0){
                result.add(new ArrayList<>(current));
                return;
            }

            if(index == candidates.length || target < 0){
                return;
            }

            // include the candidate
            current.add(candidates[index]);
            buiildCombinations(index, candidates, target - candidates[index], current, result);
            current.remove(current.size() -1);

            // exclude the candidate
            buiildCombinations(index +1, candidates, target, current, result);
        }


}