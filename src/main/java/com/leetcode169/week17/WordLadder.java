package com.leetcode169.week17;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    /**
     * Finds the shortest transformation sequence length from beginWord to endWord.
     * Each intermediate word must exist in the provided wordList, and each transformation
     * must change exactly one letter at a time.
     *
     * @param beginWord the starting word for the transformation sequence
     * @param endWord the target word to reach
     * @param wordList a list of valid words that can be used in the transformation sequence
     * @return the length of the shortest transformation sequence including beginWord and endWord,
     *         or 0 if no such sequence exists
     *
     * Time Complexity: O(N * L * 26) where N is the number of words and L is the length of each word
     * Space Complexity: O(N) for the queue and word set
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // End word not in the list
        }


        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return level; // Found the end word
                }

                // Generate all possible transformations
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] chars = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
                            wordSet.remove(nextWord); // Mark as visited
                        }
                    }
                }
            }
            level++;
        }

        return 0; // No transformation sequence found
    }
}
