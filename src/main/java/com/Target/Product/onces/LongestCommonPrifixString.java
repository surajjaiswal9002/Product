package com.Target.Product.onces;

public class LongestCommonPrifixString {
    public static void main(String[] args) {

        String[] s = {"flow", "flower", "flight"};

        String start = s[0];
        String last = s[s.length - 1];

        int i = 0;

        while (i < start.length() && i < last.length() && start.charAt(i) == last.charAt(i)) {
            i++;
        }

        System.out.println(start.substring(0, i));
    }
}
