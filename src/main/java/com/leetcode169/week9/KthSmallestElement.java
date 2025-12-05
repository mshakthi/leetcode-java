package com.leetcode169.week9;

import java.util.ArrayList;
import java.util.List;

import com.commonDataTypes.TreeNode;

public class KthSmallestElement {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> elements = new ArrayList<>();
        inOrder(root, elements);
        return elements.get(k - 1);
        
    }

    /**
     * Performs an in-order traversal of a binary tree and collects node values in a list.
     * In-order traversal visits nodes in the following order: left subtree, root, right subtree.
     * For a binary search tree, this produces values in ascending sorted order.
     *
     * @param node the current node being visited in the traversal
     * @param elements the list to store the node values in traversal order
     */
    public void inOrder(TreeNode node, List<Integer> elements){
        if(node == null){
            return;
        }

        inOrder(node.left, elements);
        elements.add(node.val);
        inOrder(node.right, elements);
    }
    
}
