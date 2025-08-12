package com.Target.Product.onee;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueChar {
    public static void main(String[] args) {

        String s = "geeksforgeeks";   // abcabcab , bbbbb

        findLSWRC(s);
    }

    public static void findLSWRC(String s){
        Set<Character> uniqueChar = new HashSet<>();
        int left = 0, maxLen = 0;
        String lswrc = "";

        for(int right = 0; right < s.length(); right++){
            char currChar = s.charAt(right);

            while(uniqueChar.contains(currChar)){
                uniqueChar.remove(s.charAt(left));
                left++;
            }

            uniqueChar.add(currChar);

            if(maxLen < right - left + 1){
                maxLen = right - left + 1;
                lswrc = s.substring(left, right);
            }
        }


        System.out.println(" Longest subsequence without non repeated character : "+maxLen + " , char = "+lswrc);
    }


}
