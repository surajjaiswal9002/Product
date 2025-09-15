package com.Target.Product.DSA001;

import java.util.*;

public class Accurance {
	public static void main(String[] args) {
		String s = "suraj jaiswal";
		
		findAccuranceUsingMap(s);
		findAccuranceUsing26Freq(s);
		findAccuranceUsing26FreqSameOrder(s);
	}
	
	public static void findAccuranceUsingMap(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		System.out.println(" Accurance using map : \n "+map);
	}
	
	public static void findAccuranceUsing26Freq(String s) {
		int[] freq = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(ch != ' ') {
				freq[ch - 'a']++;
			}
		}
		
		
		for(int i= 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch != ' ') {
				System.out.println((char)(i + 'a') +" - "+freq[ch - 'a']);
			}
		}
	}
	
	public static void findAccuranceUsing26FreqSameOrder(String s) {
		int[] freq = new int[26];
		
		System.out.println(" Same Order \n ");
		
		
		for(int i = 0; i < s.length();i++) {
			char ch = s.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				freq[ch - 'a']++;
			}
		}
		
		// to print in same order
		boolean[] printed = new boolean[26];
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				if(!printed[ch - 'a']) {
					System.out.println(ch+" - "+freq[ch - 'a']);
					printed[ch - 'a'] = true;
				}
			}
		}
	}
	
}
