package com.Target.Product.DSA;

import java.util.HashMap;

public class Accurance {
	public static void main(String[] args) {

		String s = "surajjaiswal";

		findAccuranceUsingMap(s);
		accuranceUsing26Char(s);
	}

	// tc - O(n) and sc - O(n)
	public static void findAccuranceUsingMap(String s) {
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		System.out.println(" Accurance using map : " + map);
	}

	// tc - O(n) and sc - O(1)
	public static void accuranceUsing26Char(String s) {
		int[] freq = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				freq[ch - 'a']++;
			}
		}

		// print result
		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0) {
				System.out.println((char) (i + 'a') + " - " + freq[i]);
			}
		}
	}
}
