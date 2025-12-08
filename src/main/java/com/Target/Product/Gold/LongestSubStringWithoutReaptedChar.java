package com.Target.Product.Gold;

import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutReaptedChar {
	public static void main(String[] args) {
		
		String str = "abcabcbb";
		
		findLSWRC(str);
		
	}
	
	
	// tc - (n)  and sc - O(n)
	public static void findLSWRC(String s) {
		
		Set<Character> uniqueSet = new HashSet<Character>();
		int left = 0;
		int lengthOfLongestChar = 0;
		int startIndex = 0;
		int n = s.length();
		
		
		for(int right = 0; right < n; right++) {
			char currChar = s.charAt(right);
			
			while(uniqueSet.contains(currChar)) {
				uniqueSet.remove(s.charAt(left));
				left++;
			}
			
			uniqueSet.add(currChar);
			if(lengthOfLongestChar < right - left + 1) {
				lengthOfLongestChar = right - left + 1;
				startIndex = left;
			}
		}
		
		String lrcoString = s.substring(startIndex, startIndex + lengthOfLongestChar);
		
		System.out.println(lengthOfLongestChar);
		System.out.println(lrcoString);
		
	}
}

