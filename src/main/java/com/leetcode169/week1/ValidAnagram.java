package com.leetcode169.week1;

/**
 * ValidAnagram class provides functionality to check if two strings are anagrams of each other.
 * An anagram is a word or phrase formed by rearranging the letters of another word or phrase,
 * using all the original letters exactly once.
 */

/**
 * Determines if two strings are anagrams of each other.
 * <p>
 * This method uses a frequency counting approach with two integer arrays to track
 * the occurrence of each character (a-z) in both strings. Two strings are considered
 * anagrams if they contain the same characters with the same frequencies.
 * </p>
 * <p>
 * Time Complexity: O(n + m) where n is the length of string s and m is the length of string t
 * Space Complexity: O(1) as the arrays have a fixed size of 26
 * </p>
 * 
 * @param s the first string to compare
 * @param t the second string to compare
 * @return true if the strings are anagrams, false otherwise
 * 
 * @example
 * <pre>
 * isAnagram("anagram", "nagaram") returns true
 * isAnagram("rat", "car") returns false
 * </pre>
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] sChar = new int[26];
        int[] tChar = new int[26];
        
        for(char sCh : s.toCharArray()){
            sChar[sCh - 'a']++;
        }

        for(char tCh : t.toCharArray()){
            tChar[tCh - 'a']++;
        }


        for(int i = 0; i < 26; i++){
            if(sChar[i] != tChar[i]){
                return false;
            }
        }

        return true;
    }
}
