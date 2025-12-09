package com.leetcode169.week15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.commonDataTypes.TreeNode;

public class NodesAtDistKinBT {
    /**
     * Finds all nodes in a binary tree that are at distance K from a target node.
     * 
     * This method uses BFS (Breadth-First Search) to traverse the tree in all directions
     * (left child, right child, and parent) from the target node until it reaches nodes
     * that are exactly K edges away.
     * 
     * Algorithm:
     * 1. Build a parent map to enable upward traversal in the tree
     * 2. Perform level-order traversal starting from the target node
     * 3. Explore all three directions: left child, right child, and parent
     * 4. Track visited nodes to avoid cycles
     * 5. Stop when distance K is reached
     * 
     * @param root the root node of the binary tree
     * @param target the target node from which to measure distance K
     * @param k the distance from the target node to find all nodes
     * @return a list of values of all nodes that are exactly K distance away from target
     * 
     * Time Complexity: O(n) where n is the number of nodes in the tree
     * Space Complexity: O(n) for the parent map, visited set, and queue
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        int dist = 0;

        while(!queue.isEmpty()){
            if(dist == k){
                break;
            }

            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode curr = queue.poll();
                //check left
                if(curr.left != null && !visited.contains(curr.left)){
                    queue.offer(curr.left);
                    visited.add(curr.left);
                }

                //check right
                if(curr.right != null && !visited.contains(curr.right)){
                    queue.offer(curr.right);
                    visited.add(curr.right);
                }

                //check parent
                TreeNode parent = parentMap.get(curr);
                if(parent != null && !visited.contains(parent)){
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            dist++;
        }


        return queue.stream().map(node -> node.val).toList();
    }

    public void buildParentMap(TreeNode root, HashMap<TreeNode, TreeNode> parentMap){
        if(root == null) return;

        if(root.left != null){
            parentMap.put(root.left, root);
            buildParentMap(root.left, parentMap);
        }

        if(root.right != null){
            parentMap.put(root.right, root);
            buildParentMap(root.right, parentMap);
        }
    }
}
