package com.leetcode169.week8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Solution for LeetCode problem: Letter Combinations of a Phone Number.
 * 
 * This class generates all possible letter combinations that a given string of digits 
 * (2-9) could represent on a phone keypad, similar to T9 (Text on 9 keys) input method.
 * 
 * The mapping follows the standard phone keypad layout:
 * - 2: abc
 * - 3: def
 * - 4: ghi
 * - 5: jkl
 * - 6: mno
 * - 7: pqrs
 * - 8: tuv
 * - 9: wxyz
 * 
 * Algorithm:
 * Uses backtracking to explore all possible combinations by:
 * 1. Building a mapping of digits to their corresponding letters
 * 2. Recursively generating combinations by selecting one letter at a time
 * 3. Backtracking to explore alternative letter choices
 * 
 * Time Complexity: O(4^n * n) where n is the length of the input string
 * - 4^n for the number of possible combinations (worst case with digits 7 and 9)
 * - n for building each combination string
 * 
 * Space Complexity: O(n) for the recursion call stack
 * 
 * Example:
 * Input: "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 */
public class LetterCombinationsOfPhone {
    HashMap<Character, List<Character>> letterCombinations;

        public List<String> letterCombinations(String digits) {
            buildLetterCombinations();

            List<String> result = new ArrayList<>();
            buildCombinations(0, digits, new StringBuilder(), result);
            return result;
    
        }

        public void buildCombinations(int index, String digits, StringBuilder current, List<String> result){
            if(index == digits.length()){
                result.add(current.toString());
                return;
            }

            char digit = digits.charAt(index);
            for(char letter : letterCombinations.get(digit)){
                current.append(letter);
                buildCombinations(index +1, digits, current, result);
                current.deleteCharAt(current.length() -1);
            }
        }


        public void buildLetterCombinations(){
        letterCombinations = new HashMap<>();

        letterCombinations.put('2', List.of('a','b', 'c'));
        letterCombinations.put('3', List.of('d','e', 'f'));
        letterCombinations.put('4', List.of('g','h', 'i'));
        letterCombinations.put('5', List.of('j','k', 'l'));
        letterCombinations.put('6', List.of('m','n', 'o'));
        letterCombinations.put('7', List.of('p','q', 'r', 's'));
        letterCombinations.put('8', List.of('t','u', 'v'));
        letterCombinations.put('9', List.of('w','x', 'y','z'));
    }
    
}
