/**
 * Solution for determining if two binary trees are structurally identical and have the same node values.
 * This class implements a recursive approach to compare two binary trees.
 */
/**
 * Checks if two binary trees are identical.
 * Two binary trees are considered the same if they are structurally identical
 * and the nodes have the same values.
 *
 * @param p the root node of the first binary tree
 * @param q the root node of the second binary tree
 * @return true if both trees are identical, false otherwise
 * 
 * Algorithm:
 * - Base case: If either node is null, return true only if both are null
 * - If the values of current nodes differ, return false
 * - Recursively check if left subtrees are identical AND right subtrees are identical
 * 
 * Time Complexity: O(min(n, m)) where n and m are the number of nodes in each tree
 * Space Complexity: O(min(h1, h2)) where h1 and h2 are the heights of the trees (due to recursion stack)
 */
package com.leetcode169.week3;

import com.commonDataTypes.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            return p==q;
        }

        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}
