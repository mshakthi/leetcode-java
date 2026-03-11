package com.leetcode169.week19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

    /**
     * Finds all pairs of distinct indices (i, j) in the given array of words such that
     * the concatenation of words[i] and words[j] forms a palindrome.
     *
     * The method considers three cases for each word:
     * 1. Direct palindrome pairs: If the reverse of a word exists in the array and is not itself.
     * 2. Valid suffixes: For each suffix of the word that forms a palindrome, checks if the reverse of the remaining prefix exists.
     * 3. Valid prefixes: For each prefix of the word that forms a palindrome, checks if the reverse of the remaining suffix exists.
     *
     * @param words An array of strings to be checked for palindrome pairs.
     * @return A list of lists, where each inner list contains two integers representing the indices of words that form a palindrome when concatenated.
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wordSet = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            wordSet.put(words[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (String word : wordSet.keySet()) {
            int currentIndex = wordSet.get(word);
            String reversedWord = new StringBuilder(word).reverse().toString();

            // Case 1: Check for valid palindrome pair
            if (wordSet.containsKey(reversedWord) && wordSet.get(reversedWord) != currentIndex) {
                result.add(List.of(currentIndex, wordSet.get(reversedWord)));
            }

            // Case 2: Check for valid suffixes
            for (String validSuffix : allValidSuffixes(word)) {
                String reversedSuffix = new StringBuilder(validSuffix).reverse().toString();
                if (wordSet.containsKey(reversedSuffix)) {
                    result.add(List.of(currentIndex, wordSet.get(reversedSuffix)));
                }
            }

            // Case 3: Check for valid prefixes
            for (String validPrefix : allValidPrefixes(word)) {
                String reversedPrefix = new StringBuilder(validPrefix).reverse().toString();
                if (wordSet.containsKey(reversedPrefix)) {
                    result.add(List.of(wordSet.get(reversedPrefix), currentIndex));
                }
            }
        }

        return result;

    }

    public List<String> allValidSuffixes(String word) {
        List<String> validSuffixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word, i, word.length() - 1)) {
                validSuffixes.add(word.substring(0, i));
            }
        }
        return validSuffixes;
    }

    public List<String> allValidPrefixes(String word) {
        List<String> validPrefixes = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindrome(word, 0, i)) {
                validPrefixes.add(word.substring(i + 1));
            }
        }
        return validPrefixes;
    }

    public boolean isPalindrome(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
