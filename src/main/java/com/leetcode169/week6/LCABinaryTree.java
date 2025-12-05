package com.leetcode169.week6;

import com.commonDataTypes.TreeNode;

public class LCABinaryTree {

    /**
     * Finds the lowest common ancestor (LCA) of two nodes in a binary tree.
     * 
     * The lowest common ancestor is defined as the lowest node in the tree that has both p and q
     * as descendants (where a node can be a descendant of itself).
     * 
     * Algorithm:
     * - Uses recursive depth-first search to traverse the tree
     * - If current node is null, returns null
     * - If current node matches either p or q, returns current node
     * - Recursively searches left and right subtrees
     * - If both subtrees return non-null values, current node is the LCA
     * - If only one subtree returns non-null, that value is propagated up
     * 
     * @param root the root node of the binary tree
     * @param p the first node to find LCA for
     * @param q the second node to find LCA for
     * @return the lowest common ancestor of nodes p and q, or null if not found
     * 
     * Time Complexity: O(n) where n is the number of nodes in the tree
     * Space Complexity: O(h) where h is the height of the tree (recursive call stack)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        } else if(left != null){
            return left;
        } else {
            return right;
        }
        
    }
    
}
