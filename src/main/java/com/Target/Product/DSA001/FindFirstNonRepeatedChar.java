package com.Target.Product.DSA001;



// tc - O(n) amnd sc - O(1)
public class FindFirstNonRepeatedChar {
	public static void main(String[] args) {
		String s = "suraj jaiswal";
		
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
}
