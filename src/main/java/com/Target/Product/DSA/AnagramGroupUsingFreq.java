package com.Target.Product.DSA;


import java.util.*;

public class AnagramGroupUsingFreq {
    public static void main(String[] args) {
        String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };
        groupOfAnagram(str);
    }

    // TC: O(n * k) where n = number of strings, k = average string length
    // SC: O(n * k)
    public static void groupOfAnagram(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] freq = new int[26]; // Only lowercase letters assumed
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            // Create a unique key based on frequency counts
            StringBuilder keyBuilder = new StringBuilder();
            for (int f : freq) {
                keyBuilder.append(f).append('#'); // delimiter to avoid collision
            }
            String key = keyBuilder.toString();
            System.out.println(" Key :"+key);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        List<List<String>> result = new ArrayList<>(map.values());
        System.out.println("Group of Anagram (List): " + result);
        System.out.println("Group of Anagram (Map): " + map.values());
    }
}
