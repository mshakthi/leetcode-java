package com.leetcode169.week14;

import java.util.HashMap;

import com.commonDataTypes.TreeNode;

/**
 * LeetCode 437: Path Sum III
 * 
 * Given the root of a binary tree and an integer targetSum, return the number of paths
 * where the sum of the values along the path equals targetSum.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (i.e., traveling only from parent nodes to child nodes).
 * 
 * Approach: Uses prefix sum technique with HashMap to track cumulative sums.
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(n) for the recursion stack and HashMap
 */
public class PathSumIII {
    /**
     * Finds the number of paths that sum to targetSum in the binary tree.
     * 
     * @param root the root node of the binary tree
     * @param targetSum the target sum to find
     * @return the number of paths with sum equal to targetSum
     */
    public int pathSum(TreeNode root, int targetSum) {
        // Map to store prefix sums and their frequencies
        HashMap<Long, Integer> prefixSum = new HashMap<>();
        // Initialize with 0 sum occurring once (for paths starting from root)
        prefixSum.put(0l, 1);
        return dfs(root, 0l, targetSum, prefixSum); 
    }

    /**
     * Performs DFS traversal to count paths with the target sum.
     * 
     * Uses the prefix sum technique: if (currSum - targetSum) exists in the map,
     * it means there's a path from that previous node to current node that sums to targetSum.
     * 
     * @param node the current node being processed
     * @param currSum the cumulative sum from root to current node
     * @param targetSum the target sum to find
     * @param prefixSum map storing prefix sums and their frequencies
     * @return the count of valid paths from this node and its subtrees
     */
    private int dfs(TreeNode node, long currSum, int targetSum, HashMap<Long, Integer> prefixSum){
        // Base case: null node contributes 0 paths
        if(node == null){
            return 0;
        }

        // Update current cumulative sum
        currSum += node.val;
        // Calculate what prefix sum we need to find (currSum - targetSum)
        long rem = currSum - targetSum;
        int res = 0;
        
        // Count how many times this remainder has been seen
        // Each occurrence represents a valid path ending at current node
        int prefixCount = prefixSum.getOrDefault(rem, 0);
        res += prefixCount;

        // Add current sum to the map for downstream nodes
        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        // Recursively process left and right subtrees
        res += dfs(node.left, currSum, targetSum, prefixSum);
        res += dfs(node.right, currSum, targetSum, prefixSum);

        // Backtrack: remove current sum from map before returning to parent
        // This ensures the prefix sum is only visible to nodes in current path
        prefixSum.put(currSum, prefixSum.get(currSum) - 1);

        return res;
    }
}
