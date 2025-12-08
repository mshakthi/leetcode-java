package com.leetcode169.week12;

import com.commonDataTypes.TreeNode;

public class InOrderSuccessorBST {

    TreeNode prev = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inOrderSuccessorHelper(root, p);
    }

    /**
     * Recursively finds the in-order successor of a given node in a binary search tree.
     * 
     * This method performs an in-order traversal (left-root-right) to find the successor.
     * The successor is defined as the node that comes immediately after the given node 'p'
     * in the in-order traversal sequence.
     * 
     * @param root the root of the binary search tree or subtree to search
     * @param p the node whose in-order successor needs to be found
     * @return the in-order successor node of 'p', or null if no successor exists
     * 
     * @apiNote This method relies on a class-level 'prev' variable to track the previously
     *          visited node during traversal. The 'prev' variable must be properly initialized
     *          before calling this method.
     */
    public TreeNode inOrderSuccessorHelper(TreeNode root, TreeNode p) {
        if( root == null) {
            return null;
        }

        TreeNode left = inOrderSuccessorHelper(root.left, p);
        if(left != null) {
            return left;
        }

        if(prev == p) {
            return root;
        }

        prev = root;
        return inOrderSuccessorHelper(root.right, p);
    }
    
}
