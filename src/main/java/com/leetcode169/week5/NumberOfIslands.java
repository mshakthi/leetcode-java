/**
 * Solution for LeetCode problem: Number of Islands
 * 
 * This class provides a solution to count the number of islands in a 2D binary grid.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * 
 * Algorithm: Depth-First Search (DFS)
 * Time Complexity: O(m * n) where m is the number of rows and n is the number of columns
 * Space Complexity: O(m * n) for the visited array and recursive call stack
 */

/**
 * Counts the number of islands in a 2D grid.
 * 
 * @param grid a 2D character array where '1' represents land and '0' represents water
 * @return the total number of islands found in the grid
 */

/**
 * Performs depth-first search to mark all connected land cells as visited.
 * 
 * This method recursively explores all four directions (up, down, left, right)
 * from the current cell to mark all cells that belong to the same island.
 * 
 * @param i the current row index
 * @param j the current column index
 * @param grid the 2D character array representing the map
 * @param visited a 2D boolean array to track visited cells
 */
package com.leetcode169.week5;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int islandCount = 0;

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    islandCount++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return islandCount;
    }


    public void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || i>=m || j<0 ||j >=n || visited[i][j] || grid[i][j] == '0'){
            return;
        }

        visited[i][j] = true;
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int [] dir: directions){
            int newI = i + dir[0];
            int newJ = j + dir[1];
            dfs(newI, newJ, grid, visited);
        }
    }
}
