/**
 * Solution for the Alien Dictionary problem (LeetCode 269).
 * 
 * <p>Given a sorted dictionary of an alien language, derives the order of characters
 * in that language. The solution uses topological sorting to determine the character order
 * based on lexicographical comparison of adjacent words.</p>
 * 
 * <p><b>Algorithm:</b></p>
 * <ol>
 *   <li>Initialize a graph and in-degree map with all unique characters from the dictionary</li>
 *   <li>Build directed edges by comparing adjacent word pairs to find character ordering</li>
 *   <li>Apply Kahn's algorithm (topological sort using BFS) to determine the final order</li>
 *   <li>Detect cycles or invalid orderings (returns empty string if found)</li>
 * </ol>
 * 
 * <p><b>Time Complexity:</b> O(C) where C is the total number of characters in all words</p>
 * <p><b>Space Complexity:</b> O(1) or O(26) for the graph and in-degree structures (constant for alphabet size)</p>
 * 
 * <p><b>Edge Cases Handled:</b></p>
 * <ul>
 *   <li>Invalid prefix ordering (e.g., ["abc", "ab"])</li>
 *   <li>Cycles in the character ordering</li>
 *   <li>Multiple valid orderings (returns one valid solution)</li>
 * </ul>
 * 
 */
package com.leetcode169.week19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AlienDictionary {
    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();

        // 1. Initialize graph and inDegree with all unique characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // 2. Build edges from adjacent word pairs
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if (!buildEdge(w1, w2, graph, inDegree)) {
                // invalid prefix case: e.g. "abc", "ab"
                return "";
            }
        }

        // 3. Topological sort (Kahn’s algorithm)
        StringBuilder sb = new StringBuilder();
        topoSort(graph, inDegree, sb);

        // If we didn't process all characters, there is a cycle
        if (sb.length() < inDegree.size()) {
            return "";
        }

        return sb.toString();
    }

    private void topoSort(HashMap<Character, List<Character>> graph,
                          HashMap<Character, Integer> inDegree,
                          StringBuilder sb) {

        Queue<Character> zeroInDegree = new LinkedList<>();

        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                zeroInDegree.offer(c);
            }
        }

        while (!zeroInDegree.isEmpty()) {
            char curr = zeroInDegree.poll();
            sb.append(curr);

            for (char neighbor : graph.get(curr)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    zeroInDegree.offer(neighbor);
                }
            }
        }
    }

    /**
     * Returns false if an invalid order is detected (like "abc", "ab").
     */
    private boolean buildEdge(String w1, String w2,
                              HashMap<Character, List<Character>> graph,
                              HashMap<Character, Integer> inDegree) {

        int len1 = w1.length();
        int len2 = w2.length();
        int len = Math.min(len1, len2);

        // Find the first differing character
        for (int i = 0; i < len; i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);

            if (c1 != c2) {
                List<Character> neighbors = graph.get(c1);
                // Avoid duplicate edges
                if (!neighbors.contains(c2)) {
                    neighbors.add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                }
                return true; // Valid difference handled
            }
        }

        // No difference found; check invalid prefix: "abc", "ab"
        if (len1 > len2) {
            return false;
        }

        return true;
    }
}