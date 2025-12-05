package com.leetcode169.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

    /**
     * Finds all starting indices of anagrams of string p in string s.
     * Uses a sliding window approach with character frequency counting to identify anagrams.
     * 
     * @param s the string to search within
     * @param p the pattern string whose anagrams need to be found
     * @return a list of starting indices where anagrams of p begin in s
     * 
     * @implNote This method uses two frequency arrays to track character counts:
     *           - One for the pattern string p (remains constant)
     *           - One for the current window in string s (updates as window slides)
     *           The window size is maintained equal to the length of p.
     * 
     * @timeComplexity O(n) where n is the length of string s
     * @spaceComplexity O(1) as the frequency arrays are fixed size (26 for lowercase letters)
     */
    public List<Integer> findAnagrams(String s, String p) {
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        countCharacters(p, pCount);

        List<Integer> result = new ArrayList<>();
        int left = 0;
        
        for(int right = 0; right < s.length();right++){
            char rightChar = s.charAt(right);
            sCount[rightChar - 'a']++;

            
            if(right - left + 1 > p.length()){
                char leftChar = s.charAt(left);
                sCount[leftChar - 'a']--;
                left++;
            }

            if(Arrays.equals(sCount, pCount)){
                result.add(right-p.length()+1);
            }
        }

        return result;
        
    }


    public void countCharacters(String str, int[] count){
        for(char c : str.toCharArray()){
            count[c - 'a']++;
        }
    }
    
}
