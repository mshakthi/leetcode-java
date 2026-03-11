package com.otherProblems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    /**
     * Finds all shortest transformation sequences from beginWord to endWord, such that:
     * - Each transformed word must exist in the wordList.
     * - Only one letter can be changed at a time.
     * - Each sequence is returned as a list of words.
     *
     * Uses BFS to explore all possible paths and collects those that reach endWord.
     *
     * @param beginWord The starting word for the transformation sequence.
     * @param endWord The target word for the transformation sequence.
     * @param wordList The list of allowed words for transformations.
     * @return A list of lists, where each inner list represents a shortest transformation sequence from beginWord to endWord.
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        queue.offer(Arrays.asList(beginWord));
        List<String> used = new ArrayList<>();
        used.add(beginWord);

        int level = 0;
        while(!queue.isEmpty()) {
            List<String> path = queue.poll();
            String lastWord = path.get(path.size() - 1);

            if(path.size() > level){
                level++;
                for(String st: used){
                    wordSet.remove(st);
                }
                used.clear();
            }
          
            if(lastWord.equals(endWord)) {
                res.add(path);
            } else {
                for(int i = 0; i < lastWord.length(); i++) {
                    char[] chars = lastWord.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String nextWord = new String(chars);
                        if(wordSet.contains(nextWord) && !path.contains(nextWord)) {
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(nextWord);
                            queue.offer(newPath);
                            used.add(nextWord);
                        }
                    }
                    
                }
            }
        }
        
        

        return res;
        
    }
}
