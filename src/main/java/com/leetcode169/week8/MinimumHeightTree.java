package com.leetcode169.week8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTree {

    /**
     * Finds the root nodes that minimize the height of trees in an undirected graph.
     * 
     * This method uses a topological sorting approach by iteratively removing leaf nodes
     * (nodes with degree 1) from the outside toward the center. The remaining nodes after
     * this process are the roots of minimum height trees.
     * 
     * Algorithm:
     * 1. Build an adjacency list representation of the graph
     * 2. Track the degree (number of connections) for each node
     * 3. Start with all leaf nodes (degree == 1) in a queue
     * 4. Iteratively remove leaf nodes layer by layer
     * 5. The last remaining nodes (1 or 2) are the MHT roots
     * 
     * @param n the number of nodes in the graph, labeled from 0 to n-1
     * @param edges a 2D array where each element [u, v] represents an undirected edge
     *              between nodes u and v
     * @return a list of root node labels that form minimum height trees. The list will
     *         contain at most 2 nodes, as a tree can have at most 2 centroids
     * 
     * @throws IllegalArgumentException implicitly if edges don't form a valid tree
     * 
     * Time Complexity: O(n) where n is the number of nodes
     * Space Complexity: O(n) for the adjacency list and auxiliary data structures
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        if (n == 1 || n == 2) {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;

        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            result.clear();

            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                degree[node]--;
                n--;

                for (int neighbor : adjList.get(node)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }

                if (n <= 2) {
                    result.add(node);
                }
            }
        }

        return result;

    }
}
