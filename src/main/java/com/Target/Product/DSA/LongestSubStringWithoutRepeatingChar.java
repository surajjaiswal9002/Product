package com.Target.Product.DSA;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingChar {
	public static void main(String[] args) {
		String s = "abcabcbb";
		lenOfLongestSubString(s);
	}

	
	// Tc - O(n) and sc - O(min(m, n) -- using sliding window
	public static void lenOfLongestSubString(String s) {
		HashSet<Character> uniqueSet = new HashSet<Character>();
		int left = 0;
		int lenOfLongestChar = 0;
		int startIndex = 0;

		for (int right = 0; right < s.length(); right++) {
			char currChar = s.charAt(right);

			
			while (uniqueSet.contains(currChar)) {
				uniqueSet.remove(s.charAt(left));
				left++;
			}

			uniqueSet.add(currChar);

			if (lenOfLongestChar < right - left + 1) {
				lenOfLongestChar = right - left + 1;
				startIndex = left;
			}
		}

		String LongestSubstring = s.substring(startIndex, startIndex + lenOfLongestChar);
		
		System.out.println(" Length of Longest Substring : " + lenOfLongestChar);
		System.out.println("  Longest Substring : " + LongestSubstring);
	}
}
