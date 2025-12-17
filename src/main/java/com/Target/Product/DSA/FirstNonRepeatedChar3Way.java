package com.Target.Product.DSA;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar3Way {

    public static void main(String[] args) {
        String input = "aprog ramming";

        System.out.println("Using Array: " + findUsingArray(input));
        System.out.println("Using LinkedHashMap: " + findUsingLinkedHashMap(input));
        System.out.println("Using Java 8 Streams: " + findUsingStreams(input));
    }

    // tc - O(n) and O(1)
    // ✅ Method 1: Using Array (for lowercase letters only)
    public static Character findUsingArray(String input) {
        int[] freq = new int[26];

        for (char c : input.toCharArray()) {
            if (c != ' ' && c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
            }
        }

        for (char c : input.toCharArray()) {
            if (c != ' ' && c >= 'a' && c <= 'z' && freq[c - 'a'] == 1) {
                return c;
            }
        }

        return null;
    }

    // ✅ Method 2: Using LinkedHashMap (works for all characters)
    public static Character findUsingLinkedHashMap(String input) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            if (c != ' ') {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }

    // ✅ Method 3: Using Java 8 Streams (concise and modern)
    public static Character findUsingStreams(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}

