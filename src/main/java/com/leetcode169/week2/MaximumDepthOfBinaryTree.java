package com.leetcode169.week2;

import com.commonDataTypes.TreeNode;

public class MaximumDepthOfBinaryTree {
        /**
         * Calculates the maximum depth of a binary tree.
         * The maximum depth is the number of nodes along the longest path from the root node
         * down to the farthest leaf node.
         *
         * @param root the root node of the binary tree
         * @return the maximum depth of the tree, or 0 if the tree is empty
         *
         * @implNote This method uses recursion to traverse the tree. The time complexity is O(n)
         *           where n is the number of nodes, and space complexity is O(h) where h is the
         *           height of the tree due to the recursive call stack.
         */
        public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return 1+ Math.max(maxDepth(root.left) , maxDepth(root.right));
        
    }
}
