package com.leetcode169.week6;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();

            buiildCombinations(0, candidates, target, new ArrayList<>(), result);
            return result;
        
        }

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