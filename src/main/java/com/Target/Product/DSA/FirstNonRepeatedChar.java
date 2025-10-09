package com.Target.Product.DSA;

public class FirstNonRepeatedChar {
    public static void main(String[] args) {
        String input = " aprog ramming";

        int[] freq = new int[26]; // for 'a' to 'z'

        // Step 1: Count frequency
        for (char c : input.toCharArray()) {
        	if(c != ' ') {
        		  freq[c - 'a']++;
        	}
        }

        // Step 2: Find first non-repeated character
        char result = 0;
        for (char c : input.toCharArray()) {
            if ( c != ' ' && freq[c - 'a'] == 1) {
                result = c;
                break;
            }
        }

        if (result != 0) {
            System.out.println("First non-repeated character: " + result);
        } else {
            System.out.println("No non-repeated character found");
        }
    }
}
 