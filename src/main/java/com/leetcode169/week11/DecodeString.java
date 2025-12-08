package com.leetcode169.week11;

import java.util.Stack;

public class DecodeString {

    /**
     * Decodes an encoded string following the pattern k[encoded_string], where the encoded_string 
     * inside the square brackets is repeated exactly k times.
     * 
     * <p>The function handles nested encoded patterns by using two stacks:
     * <ul>
     *   <li>countStack: stores the repetition counts (k values)</li>
     *   <li>stringStack: stores the strings built before encountering '[' brackets</li>
     * </ul>
     * 
     * <p>Algorithm:
     * <ol>
     *   <li>Iterate through each character in the input string</li>
     *   <li>If digit: build the complete number k (handles multi-digit numbers)</li>
     *   <li>If '[': push current k and string to respective stacks, reset for new segment</li>
     *   <li>If ']': pop from stacks, repeat current string k times, append to previous string</li>
     *   <li>If letter: append to current string being built</li>
     * </ol>
     * 
     * @param s the encoded string to decode, containing digits, letters, and brackets
     *          Example: "3[a]2[bc]" returns "aaabcbc"
     *                   "3[a2[c]]" returns "accaccacc"
     * @return the decoded string with all patterns expanded
     */
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k* 10 + (ch - '0');
            } else if(ch == '['){
                countStack.push(k);
                stringStack.push(currentString);

                //Reset for the new segment
                currentString = new StringBuilder();
                k = 0;
            } else if(ch == ']'){
                StringBuilder decodedString = stringStack.pop();
                int currentK = countStack.pop();
                for(int i = 0; i < currentK; i++){
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();  
    }
    
}
