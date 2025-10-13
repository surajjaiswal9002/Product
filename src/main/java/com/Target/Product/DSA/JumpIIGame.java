package com.Target.Product.DSA;

public class JumpIIGame {
	public static void main(String[] args) {
		
		int[] arr = {2, 3, 1, 1, 4};
		
		int ans = jumpTwo(arr);
		System.out.println(" Jump2 of given array -  "+ans);
	}
	
	
	// tc - O(n) ands sc - o(1);
	public static int jumpTwo(int[] jump) {
		int jumps = 0;
		int fasthest = 0;
		int end = 0;
		int n = jump.length - 1;
		
		for(int i = 0; i < n; i++) {
			fasthest = Math.max(fasthest, i + jump[i]);
			
			if(i == end) {
				jumps++;
				end = fasthest;
			}
		}
		
		return jumps;
	}

}
