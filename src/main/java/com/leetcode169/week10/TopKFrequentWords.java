package com.leetcode169.week10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Helper class to store a word and its frequency count.
 * Implements Comparable for priority queue ordering.
 */
class WordCount implements Comparable<WordCount>{
    String word;
    int count;

    /**
     * Constructs a WordCount object.
     * 
     * @param word the word
     * @param count the frequency count of the word
     */
    WordCount(String word, int count){
        this.word = word;
        this.count = count;
    }

    /**
     * Compares this WordCount with another for ordering.
     * Sorts by count in descending order, then by word lexicographically in ascending order.
     * 
     * @param other the WordCount to compare to
     * @return negative if this comes before other, positive if after, 0 if equal
     */
    @Override
    public int compareTo(WordCount other){
        if(this.count != other.count){
            return other.count - this.count; // descending order of count
        } else {
            return this.word.compareTo(other.word); // ascending order of word
        }
    }
}

/**
 * Solution for LeetCode problem: Top K Frequent Words.
 * Finds the k most frequent words from an array of words.
 */
public class TopKFrequentWords {
    
    /**
     * Returns the k most frequent words from the input array.
     * Words are ordered by frequency (descending), with ties broken by lexicographic order (ascending).
     * 
     * @param words array of input words
     * @param k the number of top frequent words to return
     * @return list of k most frequent words
     */
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> frequency  = new HashMap<>();

        for(String word : words){
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<WordCount> wordCounts = frequency.entrySet().stream()
            .map(entry -> new WordCount(entry.getKey(), entry.getValue()))
            .toList();

        PriorityQueue<WordCount> maxHeap = new PriorityQueue<>();
        maxHeap.addAll(wordCounts);

        int i =0;
        List<String> result = new ArrayList<>();
        while(!maxHeap.isEmpty() && i < k){

            WordCount wc = maxHeap.poll();
            result.add(wc.word);
            i++;
        }

        return result;
        
    }
}
