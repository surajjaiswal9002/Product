package com.Target.Product.DSA001;

import java.util.HashMap;
import java.util.Map;

// tc - O(n) amnd sc - O(1)
public class FindFirstNonRepeatedChar {
	public static void main(String[] args) {
		String s = "suraj jaiswal";
		
		usingMap(s);
		
		int n = s.length();
		int[] freq = new int[26];
		
		for(int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				freq[ch - 'a']++;
			}		
		}
		
		
		for(char c : s.toCharArray()) {
			if(c >= 'a' && c <= 'z' && freq[c - 'a'] == 1) {
				System.out.println(" first char : "+c);
				break;
			}
		}
	}
	
	public static void usingMap(String s) {
	   Map<Character, Integer> map = new HashMap<>();

       // Count frequency of each character
       for (char ch : s.toCharArray()) {
           if (ch != ' ') { // ignore spaces
               map.put(ch, map.getOrDefault(ch, 0) + 1);
           }
       }

       // Find first non-repeated character
       for (char ch : s.toCharArray()) {
           if (ch != ' ' && map.get(ch) == 1) {
               System.out.println("First non-repeated char: " + ch);
               break;
           }
       }
	}
}
