package com.Target.Product.DSA001;

import java.util.HashSet;
import java.util.Set;

public class LonSubStringWithoutRepeatedChar {
	public static void main(String[] args) {
		String s = "abcabcbb";
		
		findLongSubString(s);
	}
	
	// tc O(n) and sc O(n)
	public static void findLongSubString(String s) {
		Set<Character> uniqueChar = new HashSet<Character>();
		int left = 0;
		int startIndex = 0;
		int longSubString = 0;
		
		for(int right = 0; right < s.length(); right++) {
			char tempChar = s.charAt(right);
			
			while(uniqueChar.contains(tempChar)) {
				uniqueChar.remove(s.charAt(left++));
			}
			
			uniqueChar.add(tempChar);
			
			if(longSubString < right - left + 1) {
				longSubString = right - left + 1;
				startIndex = left;
			}
		}
		
		
		System.out.println(" Longest SubString Withoput repeated Character : "+longSubString);
		System.out.println(" -- "+s.substring(startIndex, startIndex + longSubString));
		
		
	}
}
