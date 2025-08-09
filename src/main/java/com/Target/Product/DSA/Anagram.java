package com.Target.Product.DSA;

public class Anagram {
	public static void main(String[] args) {

		String a = "abc"
				+ "";
		String b = "cba";

		checkAnagram(a, b);
	}

	// tc - O(n) and sc - o(1)
	public static void checkAnagram(String a, String b) {
		int[] freq = new int[26];

		if(a.length() != b.length()) {
			System.out.println(" It is not a Anagram");
			return;
		}
		
		for (int i = 0; i < a.length(); i++) {
			freq[a.charAt(i) - 'a']++;
			freq[b.charAt(i) - 'a']--;
		}

		// return the output
		for (int count : freq) {
			if (count != 0) {
				System.out.println(" It is not a Anagram");
				return;
			}
		}

		System.out.println(" It is a Anagram. ");
	}
}
