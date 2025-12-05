package com.leetcode169.week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    /**
     * Groups anagrams from the given array of strings together.
     * 
     * This method uses a HashMap to group strings that are anagrams of each other.
     * Each string is sorted character-by-character to create a key, and all strings
     * that produce the same sorted key are grouped together in a list.
     * 
     * @param strs an array of strings to be grouped by anagrams
     * @return a list of lists, where each inner list contains strings that are anagrams of each other
     * 
     * @example
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 
     * @implNote Time Complexity: O(n * k log k) where n is the number of strings and k is the maximum length of a string
     *           Space Complexity: O(n * k) for storing all strings in the HashMap
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = new String(strArray);
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}
