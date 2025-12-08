package com.leetcode169.week10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class WordCount implements Comparable<WordCount>{
    String word;
    int count;

    WordCount(String word, int count){
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(WordCount other){
        if(this.count != other.count){
            return other.count - this.count; // descending order of count
        } else {
            return this.word.compareTo(other.word); // ascending order of word
        }
    }
}

public class TopKFrequentWords {
    
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
