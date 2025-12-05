package com.leetcode169.week7;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    /**
     * Determines if a string can be segmented into words from a given dictionary.
     * Uses dynamic programming to check if the string can be broken down into valid words.
     * 
     * The algorithm works by:
     * 1. Converting the word dictionary to a HashSet for O(1) lookup
     * 2. Creating a boolean DP array where dp[i] represents whether substring s[0...i-1] can be segmented
     * 3. Finding the maximum word length to optimize the search window
     * 4. For each position i, checking all possible substrings ending at i within the maxLength window
     * 5. If a valid segmentation is found (dp[j] is true and substring s[j...i-1] exists in dictionary), 
     *    marking dp[i] as true
     *
     * @param s the input string to be segmented
     * @param wordDict the list of valid words that can be used for segmentation
     * @return true if the string can be segmented into dictionary words, false otherwise
     * 
     * Time Complexity: O(n * m * k) where n is the length of string s, m is the maximum word length,
     *                  and k is the average time for substring operation
     * Space Complexity: O(n + w) where n is for the DP array and w is for the HashSet of words
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];

        int maxLength = 0;
        for(String word: wordDict){
            maxLength = Math.max(maxLength, word.length());
        }

        dp[0] = true;

        for(int i =1;i<=s.length();i++){
            for(int j = i-1;j>= Math.max(0, i-maxLength);j--){
                String sub = s.substring(j, i);
                if(dp[j] && wordSet.contains(sub)){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
}
