package com.Target.Product.intervieww;

import java.util.*;

public class StringProblem {
    public static void main(String[] args) {
       /* Given a string s, find the length of the longest substring without repeating characters.
                Example 1:
        Input: s = "abcdxyzxb"
        Output: 7*/

        String s= "pwwkew";
        System.out.println(" Input : "+s);
        int ans = checkString(s);
        System.out.println(" result : "+ans);

    }

    public static int checkSubstring(String s){
        int count = 1;
       /* for(int i = 0; i < s.length;i++)*/

        return -1;
    }

    public static int checkString(String s){
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }
        return set.size();
    }
}
