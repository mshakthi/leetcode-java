
package com.leetcode169.week1;

import com.commonDataTypes.TreeNode;

/**

 * 
 * The solution uses a depth-first search (DFS) approach with a helper method that
 * calculates the height of each subtree while simultaneously checking the balance
 * condition. This allows for O(n) time complexity with a single pass through the tree.
 * 
 */
public class BalancedBinaryTree {
    
    /**
     * Determines whether the given binary tree is balanced.
     * 
     * A tree is considered balanced if the height difference between the left and
     * right subtrees of every node is at most 1.
     * 
     * @param root the root node of the binary tree to check
     * @return true if the tree is balanced, false otherwise
     * 
     * Time Complexity: O(n) where n is the number of nodes in the tree
     * Space Complexity: O(h) where h is the height of the tree (recursion stack)
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;    
    }

    /**
     * Calculates the height of the tree rooted at the given node while checking
     * if the tree is balanced.
     * 
     * This helper method returns:
     * - The height of the tree if it is balanced
     * - -1 if the tree is not balanced
     * 
     * The balance check is performed during the height calculation, allowing for
     * early termination if an imbalance is detected.
     * 
     * @param root the root node of the subtree
     * @return the height of the subtree if balanced, -1 if unbalanced
     */
    private int getHeight(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(left == -1 || right == -1){
            return -1;  
        }

        if(Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}
