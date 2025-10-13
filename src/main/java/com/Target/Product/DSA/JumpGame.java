package com.Target.Product.DSA;

public class JumpGame {
	public static void main(String[] args) {
		
		int[] jump = {3,2,1,0,4};
		
		boolean istrue = jumpGame(jump);
		System.out.println(istrue);
	}
	
	
	// tc = O(n) ands sc - (1)
	public static boolean jumpGame(int[] jump) {
		int reach = 0;
		int n = jump.length;
		
		for(int i = 0; i < n; i++) {
			if(i > reach) return false;
			
			reach = Math.max(reach, i + jump[i]);
		}
		
		return true;
	}
}
