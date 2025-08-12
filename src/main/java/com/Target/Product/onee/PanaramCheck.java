package com.Target.Product.onee;

public class PanaramCheck {
    public static void main(String[] args) {

        String sentence = "The Quick Brown Fox Jumped Overs The Lazy Dog";

        boolean isTrue = isValidPanagram(sentence);

        System.out.println(" Is Panagram : " + isTrue);
    }

    public static boolean isValidPanagram(String sent) {
        boolean[] vis = new boolean[26];

        for (int i = 0; i < sent.length(); i++) {
            char ch = sent.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                vis[ch - 'A'] = true;
            }

            if (ch >= 'a' && ch <= 'z') {
                vis[ch - 'a'] = true;
            }
        }


        for (int i = 0; i < 26; i++) {
            if (!vis[i]) {
                return false;
            }
        }
        return true;
    }
}
