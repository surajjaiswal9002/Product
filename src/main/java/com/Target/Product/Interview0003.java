package com.Target.Product;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Interview0003 {
	public static void main(String[] args) {
		
	//	List<String> fruits= Arrays.asList(new String[]{"Chikoo", "Mango", "Banana", "Mango", "Banana", "Mango","Papaya"}); 

		//  Write a java code to return Fruits in descending order of their count.

//		  O/p:
//
//		Mango 3
//
//		Banana 2
//
//		Chikoo 1
//
//		Papaya 1
		
		
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		int n = fruits.size();
//		for(int i = 0; i < n; i++) {
//			map.put(fruits.get(i), map.getOrDefault(fruits.get(i), 0) + 1);
//		}
//		
//		
//		System.out.println(map);
//		
//		
//		List<Entry<String, Integer>> res = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
//		
//		System.out.println(res);
		
		
		
		//Find common characters from 2 strings :

			  String s1 = "asdfjkliop";

			  String s2 = "qsdwjklvop";

			//  Output : "sdjklop"
			  int n = s1.length();
			  int m = s2.length();
			
			  Set<Character> set = new HashSet<Character>();
			  Set<Character> commonSet = new HashSet<Character>();
			for(int i = 0; i < n;i++) {
				set.add(s1.charAt(i));
			}
			
			for(int i = 0; i < m ; i++) {
				if(set.contains(s2.charAt(i))) {
					commonSet.add(s2.charAt(i));
				}
			}
			
		
			System.out.println(commonSet);
			
			
			
			
			int[] freq = new int[26];
			
			
			
			
			
			
			
		
	}
}
