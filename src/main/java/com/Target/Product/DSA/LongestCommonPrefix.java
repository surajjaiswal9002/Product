package com.Target.Product.DSA;

import java.util.Arrays;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] str = {"flower","flow","flight"};
		
		String res = findLCP(str);
		System.out.println(res);
		
	}
	
	
	// tc - O(n log n+m) and sc - O(1)
	public static String findLCP(String[] str) {
		
		if(str.length == 0)
			return "";
		
		Arrays.sort(str);
		
		String first = str[0];
		String last = str[str.length - 1];
		
		int i = 0;
		
		while(i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
			i++;
		}
		
		return first.substring(0, i);
	}
}	
