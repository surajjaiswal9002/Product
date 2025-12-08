package com.Target.Product;

import java.util.*;


public class Interview009 {
	public static void main(String[] args) {
		// wAM -- String -> to find the not repeating char
		
		String s = "Hhello";  // h - 2
		String s2 = "hello";
		s = "suraj";
		
		char ans = findNotRepeatedChar(s);
		
		System.out.println();
		
		
		int[] nums = {1, 2, 3, 4, 1, 1, 2};
		
		
//		 1  2
//		 2 1 3
//		 2 3 1 -> 3 2 1 -> 
//		 3 2 1 4 -> 3 2 4 1 -> .ans..ans  4 3 2 1
//		 4 3 2 1 1 -
//		 43 2 1 1 1 
//		 4 3 2 1 1 1 2 -> 4 3 2 2 1 1 1 1
//		
		
		int k = 3;
		
		int[] kthElemnt = findKMostFreq(nums, k);
	}
	
	public static int[] findKMostFreq(int[] nums, int k ) {
		int n = nums.length;
		Map<Integer, Integer> map = new LinkedHashMap<>();
		
		for(int i = 0; i < n; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.offer(new int[] {entry.getKey(), entry.getValue()});
			
			if(pq.size() > k) {
				pq.poll();
			}
			
		}
		
		int[] res = new int[k];
		int index = 0;
		while(!pq.isEmpty()) {
			res[index++] = pq.poll()[0];
		}
		
		return new int[] {-1};
	}
	
	
	
	public static char findNotRepeatedChar(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		
		return ' ';
	}
	
	
	
	
//	String million
//	
//	1 to 10,00,000M
//	
//	1 - 1000
//	1001 - 2000
//	20001 - 3000
	
	
	
	// array interger
//	
//	int[] nums = {1, 2, 3, 4, 1, 1, 1};
//	int k = 3;
//	
//	o/p - 1, 2, 3
//	
//	k most freq element in array java
//	order does not mnatter
//	
	
	
	// S - TAR Method
	
	
	
}
