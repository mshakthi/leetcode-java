package com.leetcode169.week3;

import com.commonDataTypes.TreeNode;

/**
 * Solution for determining if a binary tree is symmetric around its center.
 * 
 * <p>A binary tree is symmetric if its left subtree is a mirror reflection of its right subtree.
 * This implementation uses a recursive approach to compare corresponding nodes from both subtrees.</p>
 * 
 * <p>Time Complexity: O(n) where n is the number of nodes in the tree, as each node is visited once.</p>
 * <p>Space Complexity: O(h) where h is the height of the tree, due to the recursive call stack.</p>
 * 
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null || t2 == null) return t1 == t2;

        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }
}
