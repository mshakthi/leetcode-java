package com.leetcode169.week3;

import com.commonDataTypes.TreeNode;

/**
 * Converts a sorted array into a height-balanced Binary Search Tree (BST).
 * 
 * <p>This class provides functionality to transform a sorted integer array into a 
 * height-balanced BST where the depth of the two subtrees of every node never 
 * differs by more than one.</p>
 * 
 * <p>The algorithm uses a divide-and-conquer approach by recursively selecting 
 * the middle element of the array as the root, then building left and right 
 * subtrees from the left and right halves of the array respectively.</p>
 * 
 * <p>Time Complexity: O(n) where n is the number of elements in the array, 
 * as each element is visited once.</p>
 * 
 * <p>Space Complexity: O(log n) for the recursion stack in a balanced tree, 
 * or O(n) considering the space used by the output tree.</p>
 * 
 * @see TreeNode
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int i, int n) {
        if (i > n) {
            return null;
        }

        int mid = i + (n - i) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, i, mid - 1);
        node.right = buildBST(nums, mid + 1, n);

        return node;
        
    }


}
