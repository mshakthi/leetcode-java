package com.leetcode169.week16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * A data structure that supports insert, remove, and getRandom operations in O(1) average time complexity.
 * 
 * This class maintains a list for random access and a HashMap for O(1) lookup.
 * The combination allows efficient insertion, deletion, and random element retrieval.
 * 
 * <p>The implementation uses the following approach:
 * <ul>
 *   <li>ArrayList stores the actual values for O(1) random access</li>
 *   <li>HashMap maps values to their indices in the ArrayList for O(1) lookup</li>
 *   <li>Remove operation swaps the element to be removed with the last element,
 *       then removes the last element to maintain O(1) time complexity</li>
 * </ul>
 * 
 */

/**
 * Inserts a value into the set if it doesn't already exist.
 * 
 * @param val the value to be inserted
 * @return true if the value was successfully inserted (not already present),
 *         false if the value already exists in the set
 * @timeComplexity O(1) average case
 */

/**
 * Removes a value from the set if it exists.
 * 
 * The removal is done by swapping the element to be removed with the last element
 * in the list, then removing the last element. This maintains O(1) time complexity.
 * 
 * @param val the value to be removed
 * @return true if the value was successfully removed (was present),
 *         false if the value doesn't exist in the set
 * @timeComplexity O(1) average case
 */

/**
 * Returns a random element from the current set of elements.
 * 
 * Each element has an equal probability of being returned.
 * 
 * @return a random element from the set
 * @throws IllegalArgumentException if the set is empty
 * @timeComplexity O(1)
 */
class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int lastElement = list.get(list.size() -1);

        list.set(index, lastElement);
        map.put(lastElement, index);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
        
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
