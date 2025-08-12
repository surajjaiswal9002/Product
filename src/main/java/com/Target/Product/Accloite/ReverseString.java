package com.Target.Product.Accloite;

public class ReverseString {
    public static void main(String[] args) {
        String s = "hello";

        reverseString(s);

        reverseStringUningBits(s);
    }

    public static void reverseString(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        int end = c.length - 1;

        while (start <= end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;

            ++start;
            --end;
        }


        System.out.println(String.valueOf(c));
    }


    public static void reverseStringUningBits(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        int end = c.length - 1;

        while (start < end) {
            c[start] ^= c[end];
            c[end] ^= c[start];
            c[start] ^= c[end];

            ++start;
            --end;
        }


        System.out.println(String.valueOf(c));
    }
}
