package com.leetcode169.week8;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class TaskCount implements Comparable<TaskCount> {
    char id;
    int count;

    public TaskCount(char id, int count) {
        this.id = id;
        this.count = count;
    }

    @Override
    public int compareTo(TaskCount other) {
        return Integer.compare(other.count, this.count);
    }
}

public class TaskScheduler {

    /**
     * Calculates the minimum number of intervals required to execute all tasks with a cooling period.
     * 
     * <p>This method schedules tasks where the same task must be separated by at least 'n' intervals.
     * It uses a greedy approach with a max heap to always execute the most frequent task first,
     * minimizing idle time.</p>
     * 
     * <p>Algorithm:</p>
     * <ol>
     *   <li>Count the frequency of each task (A-Z)</li>
     *   <li>Add all tasks with positive count to a max heap (ordered by frequency)</li>
     *   <li>In each cycle of (n+1) intervals:
     *     <ul>
     *       <li>Execute the most frequent tasks available</li>
     *       <li>Decrement their counts and store temporarily</li>
     *       <li>Add idle time if cycle isn't fully utilized</li>
     *     </ul>
     *   </li>
     *   <li>Re-add tasks with remaining count back to the heap</li>
     *   <li>Repeat until all tasks are completed</li>
     * </ol>
     * 
     * @param tasks an array of characters representing tasks to be executed (A-Z)
     * @param n the minimum number of intervals required between executing the same task
     * @return the minimum total number of intervals (including idle time) needed to complete all tasks
     * 
     * @throws NullPointerException if tasks array is null
     * 
     * @see PriorityQueue
     * @see TaskCount
     */
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        PriorityQueue<TaskCount> maxHeap = new PriorityQueue<>();
        
        for(int i =0;i<tasks.length;i++){
            taskCount[tasks[i] - 'A']++;
        }

        for(int i = 0;i<26;i++){
            if(taskCount[i] > 0){
                maxHeap.offer(new TaskCount((char)(i + 'A'), taskCount[i]));
            }
        }

        int intervals = 0;

        while(maxHeap.size() > 0){
            List<TaskCount> tempList = new ArrayList<>();
            int cycle = n + 1;

            while(cycle > 0 && maxHeap.size() > 0){
                TaskCount currentTask = maxHeap.poll();
                currentTask.count--;
                tempList.add(currentTask);
                intervals++;
                cycle--;
            }

            for(TaskCount task : tempList){
                if(task.count > 0){
                    maxHeap.offer(task);
                }
            }

            if(maxHeap.size() == 0){
                break;
            }

            intervals += cycle;
        }

        

        return intervals;
    }
    
}
