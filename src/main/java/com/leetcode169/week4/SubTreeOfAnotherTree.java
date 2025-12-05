/**
 * Solution for determining if a binary tree contains a subtree that matches another binary tree.
 * This class provides methods to check if one tree is a subtree of another by comparing
 * tree structures and node values.
 *
 * <p>A subtree is defined as a tree that consists of a node in the original tree and all
 * of its descendants. The subtree must match exactly in structure and node values.</p>
 *
 * <p>Time Complexity: O(m * n) where m is the number of nodes in root and n is the number
 * of nodes in subRoot. In the worst case, we might need to check if subRoot matches at
 * every node in root.</p>
 *
 * <p>Space Complexity: O(h) where h is the height of the tree, due to the recursive call stack.</p>
 */

/**
 * Determines if the given tree contains a subtree that matches the subRoot tree.
 * The method traverses the main tree and checks if any subtree starting from any node
 * matches the subRoot tree exactly.
 *
 * @param root the root node of the main binary tree to search in
 * @param subRoot the root node of the subtree to search for
 * @return true if subRoot is a subtree of root (including if they are identical),
 *         false otherwise. Returns false if root is null.
 */

/**
 * Checks if two binary trees are identical in structure and node values.
 * Two trees are considered the same if they have the same structure and
 * all corresponding nodes have equal values.
 *
 * @param s the root node of the first binary tree
 * @param t the root node of the second binary tree
 * @return true if both trees are structurally identical with matching node values,
 *         false otherwise. Returns true if both trees are null.
 */
package com.leetcode169.week4;

import com.commonDataTypes.TreeNode;

public class SubTreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null) return false;

        if(isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }

    public boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null || t == null) return s == t;

        return (s.val == t.val)
            && isSameTree(s.left, t.left)
            && isSameTree(s.right, t.right);
    }
    
}
