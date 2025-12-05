package com.leetcode169.week4;

import java.util.PriorityQueue;
import java.util.Queue;

class PointDistance implements Comparable<PointDistance> {
    int x;
    int y;
    int distance;

    PointDistance(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public int compareTo(PointDistance other) {
        return Integer.compare(this.distance, other.distance);
    }
}


public class KClosestPoints {
    /**
     * Finds the k closest points to the origin (0, 0) from a given array of points.
     * 
     * This method uses a max heap to efficiently track the k closest points. The distance
     * is calculated using the squared Euclidean distance formula (x² + y²) to avoid
     * floating point operations and improve performance.
     * 
     * Algorithm:
     * 1. Iterate through all points and calculate their squared distance from origin
     * 2. Add each point to a max heap
     * 3. If heap size exceeds k, remove the farthest point
     * 4. Extract remaining k points from heap into result array
     * 
     * Time Complexity: O(n log k) where n is the number of points
     * Space Complexity: O(k) for the heap
     * 
     * @param points a 2D array where each element is a point [x, y]
     * @param k the number of closest points to return
     * @return a 2D array containing the k closest points to the origin
     */
    public int[][] kClosest(int[][] points, int k) {
        Queue<PointDistance> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int distance = x * x + y * y; // Using squared distance to avoid floating point operations
            PointDistance pd = new PointDistance(x, y, distance);
            maxHeap.offer(pd);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            PointDistance pd = maxHeap.poll();
            result[index][0] = pd.x;
            result[index][1] = pd.y;
            index++;    
        }

        return result;
    
    }
}
