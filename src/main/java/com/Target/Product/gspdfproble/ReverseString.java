package com.Target.Product.gspdfproble;


// Tc - O(n) and sc = O(1)
public class ReverseString {
    public static void main(String[] args) {

        String s = "hello";

        int start = 0;
        int end = s.length() - 1;

        char ch[] = s.toCharArray();

        while (start < end) {
            ch[start] ^= ch[end];
            ch[end] ^= ch[start];
            ch[start] ^= ch[end];

            ++start;
            --end;
        }

        System.out.println("reverse string : " + String.valueOf(ch));
    }
}
