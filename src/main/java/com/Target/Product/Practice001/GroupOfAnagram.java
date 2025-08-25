package com.Target.Product.Practice001;

import java.util.*;

public class GroupOfAnagram {
	public static void main(String[] args) {
		String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };

		groupOfAnagram(str);
	}
	
	public static void groupOfAnagram(String[] s) {
		Map<String, List<String>> map = new HashMap<>();
		
		for(String word : s) {
			
			char[] ch = word.toCharArray();
			Arrays.sort(ch);
			String newWord = new String(ch);
			
			map.putIfAbsent(newWord, new ArrayList<>());
			map.get(newWord).add(word);
		}
		
		List<List<String>> entries = new ArrayList<List<String>>(map.values());
		
		System.out.println(entries);
	}
}
