package com.leetcode169.week2;

/**
 * Solution for adding two binary strings.
 * Performs binary addition digit by digit with carry propagation.
 */
public class AddBinary {
    /**
     * Adds two binary strings and returns their sum as a binary string.
     * 
     * @param a the first binary string
     * @param b the second binary string
     * @return the sum of a and b as a binary string
     */
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        
        if(n<m){
            return addBinary(b, a);
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int j = m -1;

        for(int i = n-1;i>=0;i--){
            if(a.charAt(i) == '1'){
                carry++;
            }

            if(j >=0 && b.charAt(j) == '1'){
                carry++;
            }

            if(carry %2 == 1){
                sb.append('1');
            }else{
                sb.append('0'); 
            }

            carry = carry /2;
            j--;
        }

        if(carry == 1){
            sb.append('1');
        }   

        return sb.reverse().toString();


        
    }
}
