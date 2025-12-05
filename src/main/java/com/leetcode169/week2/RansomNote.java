package com.leetcode169.week2;

public class RansomNote {
    /**
     * Determines whether a ransom note can be constructed using letters from a magazine.
     * Each letter in the magazine can only be used once in the ransom note.
     * 
     * This method uses a frequency array to count the occurrence of each lowercase letter
     * in the magazine, then decrements the count for each letter used in the ransom note.
     * If any required letter is not available (count becomes 0), the method returns false.
     * 
     * Time Complexity: O(m + n) where m is the length of magazine and n is the length of ransomNote
     * Space Complexity: O(1) as the array size is fixed at 26 for lowercase English letters
     * 
     * @param ransomNote the string representing the ransom note to be constructed
     * @param magazine the string representing the magazine containing available letters
     * @return true if the ransom note can be constructed from the magazine letters, false otherwise
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] magazineChars = new char[26];

        for(char magChar : magazine.toCharArray()){
            magazineChars[magChar - 'a']++;
        }

        for(char ransomChar : ransomNote.toCharArray()){
            if(magazineChars[ransomChar - 'a'] == 0){
                return false;
            }
            magazineChars[ransomChar - 'a']--;
        }

        return true;

        
    } 
}
