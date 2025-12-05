package com.leetcode169.week5;

import com.commonDataTypes.TreeNode;

/**
 * Solution class for validating whether a binary tree is a valid Binary Search Tree (BST).
 * A valid BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 */

/**
 * Validates whether the given binary tree is a valid Binary Search Tree.
 * 
 * @param root the root node of the binary tree to validate
 * @return true if the tree is a valid BST, false otherwise
 */

/**
 * Helper method to recursively validate the BST property with min and max constraints.
 * 
 * @param node the current node being validated
 * @param min the minimum value that the current node's value must be greater than
 * @param max the maximum value that the current node's value must be less than
 * @return true if the subtree rooted at node satisfies the BST property within the given constraints, false otherwise
 */
public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isValidBSTHelper(node.left, min, node.val)
                && isValidBSTHelper(node.right, node.val, max);
    }

}
