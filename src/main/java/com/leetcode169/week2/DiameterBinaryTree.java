package com.leetcode169.week2;

import com.commonDataTypes.TreeNode;

public class DiameterBinaryTree {

    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return maxDiameter;
        
    }

    /**
     * Calculates the height of a binary tree node while updating the maximum diameter.
     * 
     * This method recursively computes the height of the tree rooted at the given node.
     * During the traversal, it calculates the diameter at each node (sum of left and right heights)
     * and updates the global maximum diameter if a larger value is found.
     * 
     * @param node the root node of the tree or subtree to measure
     * @return the height of the tree rooted at the given node, where height is defined as
     *         the number of nodes along the longest path from the node to a leaf.
     *         Returns 0 if the node is null.
     */
    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        int diameterAtNode = leftHeight + rightHeight;
        maxDiameter = Math.max(maxDiameter, diameterAtNode);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
