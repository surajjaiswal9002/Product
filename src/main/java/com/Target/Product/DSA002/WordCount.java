package com.Target.Product.DSA002;

import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String s = "Hello hello my name is Suraj and my name is Java";

        Map<String, Integer> wordCount = countWords(s);

        System.out.println(wordCount);
    }

    public static Map<String, Integer> countWords(String s) {
        Map<String, Integer> map = new HashMap<>();

        // split by non-word characters (handles spaces, commas, etc.)
        String[] words = s.trim().split("\\s+"); 

        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        return map;
    }
}
