package com.leetcode169.week1;

import com.commonDataTypes.TreeNode;

/**
 * Solution for finding the Lowest Common Ancestor (LCA) in a Binary Search Tree.
 * 
 * This class implements an algorithm to find the lowest common ancestor of two nodes
 * in a Binary Search Tree by leveraging the BST property where left subtree values
 * are less than the root and right subtree values are greater than the root.
 * 
 * Time Complexity: O(h) where h is the height of the tree
 * Space Complexity: O(h) due to recursive call stack
 */
public class LCABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null){
           return null;
       }

       if(p.val < root.val && q.val < root.val){
           return lowestCommonAncestor(root.left, p, q);
       } else if(p.val > root.val && q.val > root.val){
           return lowestCommonAncestor(root.right, p, q);
       } else {
           return root;
       }
        
    }
}
