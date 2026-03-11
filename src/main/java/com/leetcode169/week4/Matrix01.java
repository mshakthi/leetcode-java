/**
 * Solution for LeetCode problem 542 - 01 Matrix.
 * 
 * This class finds the distance of the nearest 0 for each cell in a binary matrix.
 * Uses BFS (Breadth-First Search) algorithm starting from all cells containing 0.
 * 
 * Time Complexity: O(m * n) where m is the number of rows and n is the number of columns
 * Space Complexity: O(m * n) for the queue and distance matrix
 */

/**
 * The row index of the cell.
 */

/**
 * The column index of the cell.
 */

/**
 * The distance from the nearest 0.
 */

/**
 * Constructs an IndexedNode with the specified row, column, and distance.
 * 
 * @param row the row index of the cell
 * @param col the column index of the cell
 * @param dist the distance from the nearest 0
 */

/**
 * Updates the given matrix to contain the distance to the nearest 0 for each cell.
 * 
 * Algorithm:
 * 1. Initialize all distances to Integer.MAX_VALUE
 * 2. Add all cells containing 0 to the queue with distance 0
 * 3. Perform BFS traversal:
 *    - For each cell, explore all 4 adjacent cells (up, down, left, right)
 *    - If a shorter distance is found, update it and add to queue
 * 
 * @param mat the input binary matrix containing 0s and 1s
 * @return a matrix where each cell contains the distance to the nearest 0
 */
package com.leetcode169.week4;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[] { i, j });
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        // Multi-source BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (dist[nr][nc] > dist[r][c] + 1) {
                        dist[nr][nc] = dist[r][c] + 1;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
        }

        return dist;
    }
}
