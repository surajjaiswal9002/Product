package com.Target.Product.Practice001;

public class Anagram {
	public static void main(String[] args) {
		String a = "abc";
		String b = "cbad";
		
		checkAnagram(a, b);
	}
	
	public static void checkAnagram(String a, String b) {
		int[] freq = new int[26];
		
		//  base case
		if(a.length() != b.length()) {
			System.out.println(" Not a anagram");
			return;
		}
		
		
		for(int i = 0; i < a.length(); i++) {
			char ch1 = a.charAt(i);
			char ch2 = b.charAt(i);
			
			freq[ch1 - 'a']++;
			freq[ch2 - 'a']--;
			
		}
		
		for(int i = 0; i < freq.length; i++) {
			if(freq[i] > 0) {
				System.out.println(" Not a Anagram ");
				return;
			}
		}
		
		System.out.println(" Anagram ");
	}
}
