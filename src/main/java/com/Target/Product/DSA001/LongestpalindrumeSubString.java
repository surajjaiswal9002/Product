package com.Target.Product.DSA001;

public class LongestpalindrumeSubString {
	public static void main(String[] args) {
		String s = "babad";
		
		findLongestPalindrome(s);
	}
	
	
	// tc - O(n^2) and sc O(1)
	public static void findLongestPalindrome(String s) {
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i+1);
			int len = Math.max(len1, len2);
			
			if(len > end - start) {
				start = i - (len - 1) / 2;
				end =  i+ len / 2;
			}
		}
		
		
		System.out.println(s.substring(start, end + 1));
	}
	
	
	public static int expandAroundCenter(String s, int left, int right) {
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		
		return right - left - 1;
	}
	
	
}
