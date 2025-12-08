package com.leetcode169.week11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTree {
    /**
     * Determines if a given undirected graph forms a valid tree.
     * 
     * A valid tree must satisfy two conditions:
     * 1. All nodes must be connected (single connected component)
     * 2. There must be no cycles in the graph
     * 
     * The method constructs an adjacency list representation of the graph and performs
     * a depth-first search (DFS) to check for cycles. After DFS, it verifies that all
     * nodes have been visited to ensure connectivity.
     * 
     * @param n the number of nodes in the graph, labeled from 0 to n-1
     * @param edges a 2D array where each element [u, v] represents an undirected edge
     *              between nodes u and v
     * @return true if the graph forms a valid tree, false otherwise
     * 
     * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
     * Space Complexity: O(V + E) for the adjacency list and visited set
     */
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        
        return dfs(adjList, 0, -1, visited) && visited.size() == n;
        
    } 
    
    public boolean dfs(List<List<Integer>> adjList, int node, int parent, Set<Integer> visited){
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);

        for(int neighbor: adjList.get(node)){
            if(neighbor == parent){
                continue;
            }


            if(!dfs(adjList, neighbor, node, visited)){
                return false;
            }
        }
        return true;
    }
}
