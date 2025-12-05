package com.leetcode169.week6;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * A time-based key-value data structure that stores multiple values for the same key at different timestamps
 * and retrieves values based on timestamp queries.
 * 
 * <p>This implementation uses a HashMap to store keys, where each key maps to a TreeMap that maintains
 * timestamp-value pairs in sorted order by timestamp. This allows for efficient retrieval of values
 * at or before a given timestamp using binary search.</p>
 * 
 * <p>Key features:</p>
 * <ul>
 *   <li>Supports storing multiple values for the same key at different timestamps</li>
 *   <li>Retrieves the value associated with the largest timestamp less than or equal to the query timestamp</li>
 *   <li>Returns empty string if no suitable value exists</li>
 * </ul>
 * 
 * <p>Time Complexity:</p>
 * <ul>
 *   <li>set operation: O(log n) where n is the number of timestamps for a key</li>
 *   <li>get operation: O(log n) where n is the number of timestamps for a key</li>
 * </ul>
 * 
 * <p>Space Complexity: O(n * m) where n is the number of unique keys and m is the average number of
 * timestamps per key</p>
 * 
 */
public class TimeMap {
    
    HashMap< String, TreeMap<Integer, String> > map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        TreeMap<Integer, String> treeMap = map.get(key);
        Integer floorKey = treeMap.floorKey(timestamp);
        if(floorKey == null){
            return "";
        }

        return treeMap.get(floorKey);
        
    }
}
