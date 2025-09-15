package com.Target.Product.DSA001;

import java.util.*;

public class AnagramGroup {
	public static void main(String[] args) {
		String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };
		
		groupOfAnagram(str);
	}
	
	// Tc - O(n * m log m) and sc = O(m * n)
	public static void groupOfAnagram(String[] str) {
		Map<String, List<String>> groupOfAna = new HashMap<String, List<String>>();  // O(n * m)
		
		for(String s : str) {
			char[] ch = s.toCharArray();  // O(m)
			Arrays.sort(ch);  // O(log m)
			String newWord = new String(ch);
			
			groupOfAna.putIfAbsent(newWord, new ArrayList<String>());
			groupOfAna.get(newWord).add(s);
		}
		
		List<List<String>> list = new ArrayList<List<String>>(groupOfAna.values());
		System.out.println(list);
	}
}
