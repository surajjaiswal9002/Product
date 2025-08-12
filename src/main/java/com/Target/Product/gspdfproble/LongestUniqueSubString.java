package com.Target.Product.gspdfproble;

import java.util.*;

public class LongestUniqueSubString {
    public static void main(String[] args) {
        String s = "geeksforgeeks";  // abcabcbb

        Set<Character> uniqueSet = new HashSet<>();
        int maxLen = 0;
        int left = 0;
        String res = "";

        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);

            if(uniqueSet.contains(currChar)) {
                uniqueSet.remove(left);
                left++;
            }

            uniqueSet.add(currChar);

            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
                res = s.substring(left, right + 1);
            }
        }

        System.out.println(maxLen + ", res - " + res);
    }
}
