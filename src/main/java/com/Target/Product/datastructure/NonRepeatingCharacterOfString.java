package com.Target.Product.datastructure;

import java.util.Arrays;

public class NonRepeatingCharacterOfString {
    public static void main(String[] args) {

        String s = "aabbcddeff";

        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        System.out.println(" Non repeated character : "+ Arrays.toString(freq));
        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1){
                System.out.println(" Non repeated character : "+s.charAt(i));
                break;
            }
        }


    }
}
