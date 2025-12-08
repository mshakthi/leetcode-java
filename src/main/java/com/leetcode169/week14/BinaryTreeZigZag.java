package com.leetcode169.week14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.commonDataTypes.TreeNode;

public class BinaryTreeZigZag {
    /**
     * Performs a zigzag level order traversal of a binary tree.
     * 
     * This method traverses the binary tree level by level, alternating the direction
     * of traversal for each level. Odd levels (starting from level 1) are traversed
     * from left to right, while even levels are traversed from right to left.
     * 
     * @param root the root node of the binary tree to traverse
     * @return a list of lists containing the node values in zigzag level order.
     *         Each inner list represents one level of the tree. Returns an empty
     *         list if the root is null.
     * 
     * @example
     * Given binary tree:
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 
     * Returns: [[3], [20, 9], [15, 7]]
     * 
     * Time Complexity: O(n) where n is the number of nodes in the tree
     * Space Complexity: O(w) where w is the maximum width of the tree (for the queue)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while(!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                // Add logic to process currentNode and add its children to the queue
                if(leftToRight) {
                    currentLevel.add(currentNode.val);
                } else {
                    currentLevel.add(0, currentNode.val);
                }

                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            } 
            
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }

        return result;
    }
}
