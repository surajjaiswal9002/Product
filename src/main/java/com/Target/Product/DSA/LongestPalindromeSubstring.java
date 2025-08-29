package com.Target.Product.DSA;

public class LongestPalindromeSubstring {
	public static void main(String[] args) {
		
		String s = "babad";
		
		String ans = palindromeSubstring(s);
		System.out.println(" ans : "+ans);
	}
	
	public static String palindromeSubstring(String s) {
		int n = s.length();
		int start = 0;
		int end = 0;
		
		if(s == null || n <= 0) return "";
		
		
		for(int i = 0; i < n; i++) {
			int len1 = expandAroundCenter(s, i, i); // Odd  length of palindrome
			int len2 = expandAroundCenter(s, i, i+1);  // even length of palindrome
			int len = Math.max(len1, len2);
			
			if(len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		
		return s.substring(start, end + 1);
		
	}
	
	
	private static int expandAroundCenter(String s, int left, int right) {
		
		
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) ) {
			left--;
			right++;
		}
		
		return right - left - 1;
	}
}
