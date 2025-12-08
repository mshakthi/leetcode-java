package com.leetcode169.week10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> pac = new HashSet<>();
        Set<List<Integer>> atl = new HashSet<>();

        int m = heights.length;
        int n = heights[0].length;

        for(int i =0;i<n;i++){
            dfs(heights, 0, i, Integer.MIN_VALUE, pac);
            dfs(heights, m - 1, i, Integer.MIN_VALUE, atl);
        }

        for(int i =0;i<m;i++){
            dfs(heights, i, 0, Integer.MIN_VALUE, pac);
            dfs(heights, i, n - 1, Integer.MIN_VALUE, atl);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> cell : pac){
            if(atl.contains(cell)){
                result.add(cell);
            }
        }

        return result;
    }

    /**
     * Performs a depth-first search (DFS) traversal on a 2D height matrix to find all cells
     * that can be reached from a starting position where water can flow.
     * 
     * Water can flow from a cell to another cell if the destination cell's height is greater
     * than or equal to the current cell's height.
     *
     * @param heights    a 2D integer array representing the height matrix where heights[i][j]
     *                   represents the height of the cell at position (i, j)
     * @param row        the current row index in the height matrix
     * @param col        the current column index in the height matrix
     * @param prevHeight the height of the previous cell from which water is flowing
     * @param visited    a Set containing Lists of Integer coordinates [row, col] representing
     *                   all cells that have been visited during the DFS traversal
     * 
     * @implNote The method explores all four directions (up, down, left, right) from the current
     *           cell and marks reachable cells in the visited set. The search stops at boundaries,
     *           previously visited cells, or cells with heights lower than the previous height.
     */
    public void dfs(int[][] heights, int row, int col, int prevHeight, Set<List<Integer>> visited){
        int m = heights.length;
        int n = heights[0].length;

        if(row < 0 || row >= m || col < 0 || col >= n){
            return;
        }

        if(heights[row][col] < prevHeight){
            return;
        }

        List<Integer> cell = new ArrayList<>();
        cell.add(row);
        cell.add(col);

        if(visited.contains(cell)){
            return;
        }

        visited.add(cell);

        dfs(heights, row + 1, col, heights[row][col], visited);
        dfs(heights, row - 1, col, heights[row][col], visited);
        dfs(heights, row, col + 1, heights[row][col], visited);
        dfs(heights, row, col - 1, heights[row][col], visited);
    }
    
}
