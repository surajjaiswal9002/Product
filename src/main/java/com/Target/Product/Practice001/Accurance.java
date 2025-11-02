package com.Target.Product.Practice001;


import java.util.*;

public class Accurance {
	public static void main(String[] args) {
		String s = "suraj jaiswal";
		findAccuranceUsingMap(s);
		accuranceUsing26Char(s);
		
		 String text = "apple banana apple mango banana apple orange"; 
		 String words[] = text.split("\\s+");
		 accuranceForArray(words);
		 accuranceForArrayWords(words);
		
		
	}
	
	
	public static void accuranceForArrayWords(String[] words) {
		String[] unique = new String[words.length];
		int[] freq = new int[unique.length];
		int uniqueCount = 0;
		
		for(String word : words) {
			boolean found = false;
			for(int i = 0; i < uniqueCount; i++) {
				if(unique[i].equals(word)) {
					freq[i]++;
					found = true;
					break;
				}
			}
			
			if(!found) {
				unique[uniqueCount] = word;
				freq[uniqueCount] = 1;
				uniqueCount++;
				
				
			}
		}
		
		System.out.println(" Words using freq");
		for(int i = 0; i < uniqueCount; i++) {
			System.out.println(unique[i] +" - "+freq[i]);
		}
		
		
	}
	
	public static void accuranceUsing26Char(String s) {
		int[] freq = new int[26];
		int n = s.length();
		for(int i = 0; i < n; i++) {
			char c = s.charAt(i);
			
			if(c == ' ') {
				continue;
			}
			
			freq[c - 'a']++;
		}
		
		
		System.out.println(" freqency of String \n "+Arrays.toString(freq));
		
		int freqSize = freq.length;
		for(int i = 0; i < freqSize; i++) {
			if(freq[i] > 0) {
				char ch = (char) (i + 'a'); 
				System.out.println( ch +" - "+freq[i]);
			}
		}
	}
	
	public static void findAccuranceUsingMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int n = s.length();
		for(int i = 0; i < n; i++) {
			
			if(s.charAt(i) == ' ') {
				continue;
			}
			
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		System.out.println(" Accurance : "+map);
		
		
		List<Map.Entry<Character, Integer>> listOfMapASC = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
		listOfMapASC.sort(Map.Entry.comparingByValue());
		
		
		
		System.out.println("\n Sort using ascending order");
		for(Map.Entry<Character, Integer> entries : listOfMapASC) {
			System.out.println(entries.getKey()+" - "+entries.getValue());
		}
		
		
		List<Map.Entry<Character, Integer>> listOfMapDESC = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
		listOfMapDESC.sort(Map.Entry.<Character, Integer>comparingByValue().reversed());
		
		
		
		System.out.println("\n Sort using descending order order");
		for(Map.Entry<Character, Integer> entries : listOfMapDESC) {
			System.out.println(entries.getKey()+" - "+entries.getValue());
		}
	}
	
	
	public static void accuranceForArray(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		
		for(String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		System.out.println(" Words - "+map);
		
		// Sort using ascending order
		System.out.println(" Word in Ascending order"
				+ " order ");
		List<Map.Entry<String, Integer>> sortUsingAsc = new ArrayList<>(map.entrySet());
		sortUsingAsc.sort(Map.Entry.comparingByValue());
		
		for(Map.Entry<String, Integer> entries : sortUsingAsc) {
			System.out.println(entries.getKey()+" - "+entries.getValue());
		}
		
		// Sort using descending order
		System.out.println(" Word in Descending order ");
		List<Map.Entry<String, Integer>> sortUsingDesc = new ArrayList<>(map.entrySet());
		sortUsingDesc.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
		
		for(Map.Entry<String, Integer> entries : sortUsingDesc) {
			System.out.println(entries.getKey()+" - "+entries.getValue());
		}	
		
	}
}
