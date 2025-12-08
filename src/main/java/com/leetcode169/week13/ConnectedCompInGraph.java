package com.leetcode169.week13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A class that counts the number of connected components in an undirected graph.
 * 
 * This implementation uses Depth-First Search (DFS) to traverse the graph and identify
 * distinct connected components. A connected component is a maximal set of vertices
 * where there is a path between any two vertices in the set.
 */

/**
 * Counts the number of connected components in an undirected graph.
 * 
 * The algorithm builds an adjacency list representation of the graph and performs
 * DFS starting from each unvisited node. Each DFS traversal identifies one complete
 * connected component.
 * 
 * @param n the number of nodes in the graph, labeled from 0 to n-1
 * @param edges a 2D array where each element [a, b] represents an undirected edge
 *              between nodes a and b
 * @return the total number of connected components in the graph
 * 
 * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
 * Space Complexity: O(V + E) for the adjacency list and O(V) for the visited set
 */

/**
 * Performs a depth-first search traversal starting from the given node.
 * 
 * This helper method recursively visits all nodes reachable from the starting node,
 * marking each visited node to avoid revisiting. This effectively explores one
 * complete connected component.
 * 
 * @param node the current node being visited
 * @param graph the adjacency list representation of the graph
 * @param visited a set tracking all nodes that have been visited during the traversal
 */
public class ConnectedCompInGraph {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int count =0;

        for(int i = 0;i<n;i++){
            if(!visited.contains(i)){
                dfs(i, graph, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, List<List<Integer>> graph, Set<Integer> visited){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);

        for(int neighbor : graph.get(node)){
            dfs(neighbor, graph, visited);
        }
    }
}
