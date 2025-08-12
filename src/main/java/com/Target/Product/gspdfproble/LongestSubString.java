package com.Target.Product.gspdfproble;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(" result : " + lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        String res = "";


        for (int right = 0; right < n; right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            if(maxLen < right - left + 1){
                maxLen = right - left + 1;
                res = s.substring(left, right + 1);
            }
        }

        System.out.println(maxLen+" -- "+res);
        return maxLen;
    }
}
