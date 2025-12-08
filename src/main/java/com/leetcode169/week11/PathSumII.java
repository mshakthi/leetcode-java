package com.leetcode169.week11;

import java.util.ArrayList;
import java.util.List;

import com.commonDataTypes.TreeNode;

public class PathSumII {
    /**
     * Finds all root-to-leaf paths in a binary tree where the sum of node values equals the target sum.
     * 
     * @param root the root node of the binary tree
     * @param targetSum the target sum that each valid path should equal
     * @return a list of lists, where each inner list represents a valid path from root to leaf
     *         whose sum equals targetSum. Returns an empty list if no such paths exist or if root is null.
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new java.util.ArrayList<>();

        buildPaths(root, 0, targetSum, new ArrayList<>(), result);
        return result;
        
    }

    public void buildPaths(TreeNode node, int currSum, int targetSum, List<Integer> currPath, List<List<Integer>> result){
        if(node == null){
            return;
        }

        currSum += node.val;
        currPath.add(node.val);

        if(node.left == null && node.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList<>(currPath));
            }
        } else {
            buildPaths(node.left, currSum, targetSum, currPath, result);
            buildPaths(node.right, currSum, targetSum, currPath, result);
        }
        
        currPath.remove(currPath.size() - 1);
    }
}
