/**
 * Calculates the maximum width of a binary tree.
 * 
 * The width of a binary tree is defined as the maximum number of nodes present at any level,
 * including null nodes between the leftmost and rightmost non-null nodes at that level.
 * 
 * This implementation uses a level-order traversal (BFS) approach with index tracking.
 * Each node is assigned an index based on its position in a complete binary tree representation:
 * - Root node has index 0
 * - Left child of node at index i has index 2*i + 1
 * - Right child of node at index i has index 2*i + 2
 * 
 * The width at each level is calculated as (last_index - first_index + 1).
 * 
 * Time Complexity: O(n) where n is the number of nodes in the tree
 * Space Complexity: O(w) where w is the maximum width of the tree (queue size)
 * 
 * @param root the root node of the binary tree
 * @return the maximum width of the binary tree, or 0 if the tree is empty
 */
package com.leetcode169.week12;

import java.util.Queue;

import com.commonDataTypes.TreeNode;

class NodeIndex {
    TreeNode node;
    int index;

    NodeIndex(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}

public class MaxWidthOfBT {

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;

        if(root == null){
            return maxWidth;
        }

        Queue<NodeIndex> queue = new java.util.LinkedList<>();
        queue.offer(new NodeIndex(root, 0));

        while(!queue.isEmpty()){
            int size = queue.size();
            int first = 0;
            int last = 0;

            for(int i =0;i< size;i++){
                NodeIndex curr = queue.poll();

                if(i ==0){
                    first = curr.index;
                }

                if(i == size -1){
                    last = curr.index;
                }

                if(curr.node.left != null){
                    queue.offer(new NodeIndex(curr.node.left, 2 * curr.index + 1));
                }

                if(curr.node.right != null){
                    queue.offer(new NodeIndex(curr.node.right, 2 * curr.index + 2));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        
        return maxWidth;
    }
    
}
