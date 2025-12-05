package com.leetcode169.week1;

import com.commonDataTypes.TreeNode;

/**
 * Solution for inverting a binary tree.
 * <p>
 * This class provides a method to invert a binary tree by swapping the left and right
 * children of all nodes recursively. The inversion is performed in-place.
 * </p>
 * 
 * <p>Example:</p>
 * <pre>
 * Input:       4                Output:      4
 *            /   \                          /   \
 *           2     7                        7     2
 *          / \   / \                      / \   / \
 *         1   3 6   9                    9   6 3   1
 * </pre>
 * 
 * <p>Time Complexity: O(n) where n is the number of nodes in the tree</p>
 * <p>Space Complexity: O(h) where h is the height of the tree (due to recursion stack)</p>
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if( root == null){
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    
}
