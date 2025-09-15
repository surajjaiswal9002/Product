 package com.Target.Product.DSA001;

public class Anagram {
	public static void main(String[] args) {
		String a = "suraj jaiswal";
		String b = "suraj jaiswal";
		
		checkAnagram(a, b);
	}
	
	public static void checkAnagram(String a, String b) {
		
		if(a.length() != b.length()) {
			System.out.println(" Not an Anagram ");
			return;
		}
		
		int[] freq = new int[26];
		
		for(int i = 0; i < a.length(); i++) {
			char chA = a.charAt(i);
			char chB = b.charAt(i);
			
			if(chA >= 'a'  && chB >= 'a' && chB <= 'z' && chA <= 'z') {
				freq[chA - 'a']++;
				freq[chB - 'a']--;
			}
		}
		
		
		for(int i = 0 ;i < freq.length; i++) {
			if(freq[i] != 0) {
				System.out.println(" Its not an anagram ");
				return;
			}
		}
		
		
		System.out.println(" Anagram ");
	}
}
