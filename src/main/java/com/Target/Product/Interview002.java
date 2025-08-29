package com.Target.Product;

import java.util.*;

public class Interview002 {
	public static void main(String[] args) {
		
		/*
		 * You are given a string s that contains only lowercase 
		 * English letters. A
		 * substring is called "nice" if it contains all distinct characters (no
		 * duplicates).
		 * 
		 * Write a Java function to:
		 * 
		 * 1. Find the length of the longest nice substring in s.
		 * 
		 * 2. Return the substring itself (if multiple substrings have the same maximum
		 * length, return any one of them). 
		 * Input: s = "abcaefghijka"
		 *  Output: Length =
		 * 10, Substring = "bcaefghijk"
		 * 
		 */
		
		String s = "abcaefghijka";
		int n = s.length();
		int left = 0;
		int startIndex = 0;
		int longSubstring = 0;
		Set<Character> uniqueString = new HashSet<>();
		
		
		
		for(int right = 0; right < n; right++) {
			char ch = s.charAt(right);
			
			while(uniqueString.contains(ch)) {
				uniqueString.remove(s.charAt(left));
				left++;
			}
			
			uniqueString.add(ch);
			
			if(longSubstring < right - left + 1) {
				longSubstring = right - left + 1;
				startIndex = left;
			}
			
		}
		
		System.out.println(longSubstring);
		System.out.println(s.substring(startIndex, startIndex + longSubstring));
		
	}
}
