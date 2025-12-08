package com.leetcode169.week11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    /**
     * Finds a valid order to complete all courses given their prerequisites using topological sorting.
     * This method implements Kahn's algorithm for topological sorting using BFS.
     * 
     * @param numCourses the total number of courses labeled from 0 to numCourses - 1
     * @param prerequisites a 2D array where prerequisites[i] = [ai, bi] indicates that 
     *                      course bi must be taken before course ai
     * @return an array representing a valid order to complete all courses, or an empty 
     *         array if it's impossible to finish all courses (cycle detected)
     * 
     * @implNote The algorithm works as follows:
     *           1. Build an adjacency list representing the course dependency graph
     *           2. Calculate in-degree for each course (number of prerequisites)
     *           3. Start with courses that have no prerequisites (in-degree = 0)
     *           4. Process courses in topological order using BFS
     *           5. For each processed course, reduce in-degree of dependent courses
     *           6. If all courses are processed, return the order; otherwise return empty array
     * 
     * @complexity Time: O(V + E) where V is numCourses and E is prerequisites.length
     *             Space: O(V + E) for the adjacency list and auxiliary data structures
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList= new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            adjList.get(pre[1]).add(pre[0]);
        }
        
        int[] inDegree = new int[numCourses];
        for(int i =0;i<numCourses;i++){
            for(int neighbor: adjList.get(i)){
                inDegree[neighbor]++;
            }
        }



        Queue<Integer> queue = new LinkedList<>();

        for(int i =0;i<numCourses;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while(!queue.isEmpty()){
            int curr = queue.poll();
            order.add(curr);

            for(int nextCourse: adjList.get(curr)){
                inDegree[nextCourse]--;
                if(inDegree[nextCourse] == 0){
                    queue.offer(nextCourse);
                }
            }
        }

        if(order.size() != numCourses){
            return new int[0];
        }

        return order.stream().mapToInt(i -> i).toArray();
    }
    
}
