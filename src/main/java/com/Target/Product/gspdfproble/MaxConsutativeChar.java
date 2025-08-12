package com.Target.Product.gspdfproble;

public class MaxConsutativeChar {
    public static void main(String[] args) {
        String s1 = "geeekk";
        String s2 = "aaaabbcbbb";

        maxConsutativeChar(s1);
    }

    public static void maxConsutativeChar(String s) {

        char maxChar = s.charAt(0);
        int maxCount = 1;

        char currChar = s.charAt(0);
        int currCount = 1;

        for (int i = 0; i < s.length(); i++) {
            if (currChar == s.charAt(i)) {
                currCount++;
            } else {
                currChar = s.charAt(i);
                currCount = 1;
            }

            if (currCount > maxCount) {
                maxCount = currCount;
                maxChar = currChar;
            }
        }


        System.out.println(maxChar);
    }
}
