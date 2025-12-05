package com.leetcode169.week5;

import java.util.HashMap;

import com.commonDataTypes.Node;

/**
 * CloneGraph - Deep clones an undirected graph using Depth-First Search (DFS) traversal.
 * 
 * This class implements a solution to clone a connected undirected graph where each node
 * contains a value and a list of its neighbors. The cloning process creates a deep copy
 * of the graph, ensuring that all nodes and their connections are duplicated.
 * 
 * Algorithm:
 * - Uses a HashMap to track already cloned nodes and prevent infinite loops
 * - Performs DFS traversal starting from the given node
 * - For each node, creates a clone and recursively clones all its neighbors
 * - Returns null if the input graph is empty
 * 
 * Time Complexity: O(N + E) where N is the number of nodes and E is the number of edges
 * Space Complexity: O(N) for the HashMap storing cloned nodes and recursion stack
 * 
 * Example:
 * Given a graph: 1 -- 2
 *                |    |
 *                4 -- 3
 * The method returns a deep copy with the same structure but different node instances.
 */
public class CloneGraph {
    
    HashMap<Node, Node> cloned = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        if(cloned.containsKey(node)) {
            return cloned.get(node);
        }

        Node cloneNode = new Node(node.val);
        cloned.put(node, cloneNode);

        for(Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
        
    }
}
