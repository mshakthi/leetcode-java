package com.leetcode169.week15;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {

    private final String SEPARATOR = "/:";
        // Encodes a list of strings to a single string.
    /**
     * Encodes a list of strings into a single string.
     * 
     * The encoding format consists of each string's length followed by a separator,
     * then the string itself. This allows for proper decoding even when strings
     * contain special characters or the separator character.
     * 
     * Format: [length][SEPARATOR][string][length][SEPARATOR][string]...
     * 
     * Example:
     * Input: ["hello", "world"]
     * Output: "5[SEPARATOR]hello5[SEPARATOR]world"
     * 
     * @param strs the list of strings to encode
     * @return a single encoded string representing all input strings
     */
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String str: strs) {
            encoded.append(str.length()).append(SEPARATOR).append(str);
        }

        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int separatorIndex = s.indexOf(SEPARATOR, i);
            int length = Integer.parseInt(s.substring(i, separatorIndex));

            
            int stringStartIndex = separatorIndex + SEPARATOR.length();
            i = stringStartIndex + length;
            String str = s.substring(stringStartIndex, i);
            result.add(str);
        }

        return result;
        
    }
}
