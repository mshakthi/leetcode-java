package com.leetcode169.week17;

import com.commonDataTypes.TreeNode;

/**
 * Solution for finding the maximum path sum in a binary tree.
 * 
 * <p>A path is defined as any sequence of nodes from some starting node to any node in the tree 
 * along the parent-child connections. The path must contain at least one node and does not need 
 * to go through the root. The path sum is the sum of the node values in the path.</p>
 * 
 * <p>This solution uses a recursive depth-first search approach with the following key insights:</p>
 * <ul>
 *   <li>At each node, we can either include it in the path or skip it</li>
 *   <li>A path can split at any node (going through both left and right children)</li>
 *   <li>We track the maximum path sum globally while computing the maximum contribution 
 *       of each subtree</li>
 * </ul>
 * 
 * <p>Time Complexity: O(n) where n is the number of nodes in the tree, as we visit each node once.</p>
 * <p>Space Complexity: O(h) where h is the height of the tree, due to the recursion stack.</p>
 * 
 */
public class BinaryTreeMaximumPathSum {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxSum;
    }

    public int maxPathDown(TreeNode node){
        if(node == null) return 0;

        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));

        maxSum = Math.max(maxSum, left + right + node.val);

        return Math.max(left, right) + node.val;
    }
    
}
