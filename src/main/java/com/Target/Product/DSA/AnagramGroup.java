package com.Target.Product.DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramGroup {
	public static void main(String[] args) {

		String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };

		groupOfAnagram(str);
	}

	// tc - O(n * k log k) and sc - O(n * k)
	public static void groupOfAnagram(String[] str) {
		HashMap<String, List<String>> groupOfAna = new HashMap<String, List<String>>();

		for (String s : str) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String word = new String(ch);

			groupOfAna.putIfAbsent(word, new ArrayList<>());
			groupOfAna.get(word).add(s);
		}

		List<List<String>> list = new ArrayList<List<String>>(groupOfAna.values());
		System.out.println(" Group of Anagram (Lis): "+list);
		System.out.println(" Group of Anagram (Map): " + groupOfAna);
	}
}


