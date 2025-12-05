package com.leetcode169.week5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    /**
     * Determines if it is possible to finish all courses given their prerequisites.
     * Uses Kahn's algorithm (topological sort with BFS) to detect if there are any cycles
     * in the course dependency graph. If a cycle exists, it's impossible to complete all courses.
     *
     * @param numCourses the total number of courses labeled from 0 to numCourses - 1
     * @param prerequisites a 2D array where prerequisites[i] = [ai, bi] indicates that
     *                      course bi must be taken before course ai
     * @return true if all courses can be finished (no cycles in the dependency graph),
     *         false otherwise
     *
     * @implNote The algorithm works as follows:
     *           1. Build an adjacency list representation of the course dependency graph
     *           2. Calculate in-degree (number of prerequisites) for each course
     *           3. Start with courses that have no prerequisites (in-degree = 0)
     *           4. Process each course and reduce in-degree of dependent courses
     *           5. If all courses are processed, return true; otherwise false (cycle detected)
     *
     * Time Complexity: O(V + E) where V is numCourses and E is prerequisites.length
     * Space Complexity: O(V + E) for the graph and auxiliary data structures
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i< prerequisites.length;i++){
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];

            graph.get(prereq).add(course);
        }

        int[] inDegree = new int[numCourses];
        for(int i =0;i<numCourses;i++){
            for(int neighbor: graph.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        int course = 0;

        while(!queue.isEmpty()){
            int currCourse = queue.poll();
            course++;

            for(int neighbor: graph.get(currCourse)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }
        
        return course == numCourses;
    }
    
}
