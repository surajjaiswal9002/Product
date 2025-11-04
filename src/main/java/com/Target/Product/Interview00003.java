package com.Target.Product;

import java.util.HashSet;
import java.util.Set;

public class Interview00003 {
	public static void main(String[] args) {
//		Given a string s, find the length of the longest substring without repeating characters.
//
//		Example 1:
//
//		Input: s = "abcdxyzxb"
//
//		Output: 7
//
//		Explanation: The answer is "abcdxyz", with the length of 7.
//
//		Example 2:
//
//		Input: s = "abcdabcbbxyzt"
//
//		Output: 5
//
//		Explanation: The answer is "bxyzt", with the length of 5.
//
//		Example 3:
//
//		Input: s = "pwwkew"
//
//		Output: 3
//
//		Explanation: The answer is "wke", with the length of 3.
//
//		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//		
//		
		
		
		
		String s= "abcdabcbbxyzt";
		
		int n = s.length();
		
		Set<Character> uniqueSet = new HashSet<Character>();
		int left  = 0;
		int lenMax = 0;
		int startIndex = 0;
		
		for(int right = 0; right < n; right++) {
			
			char tempChar = s.charAt(right);
			
			while(uniqueSet.contains(tempChar)) {
				uniqueSet.remove(s.charAt(left));
				left++;
			}
		
			System.out.println(uniqueSet);
			
			if(lenMax < right - left + 1) {
				lenMax = right - left + 1;
				startIndex = left;
			}
		}
		//System.out.println(uniqueSet);
		
		System.out.println(lenMax);
		System.out.println(s.substring(startIndex, startIndex + lenMax));
		
		
		
	}
}
