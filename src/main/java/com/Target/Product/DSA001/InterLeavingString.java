package com.Target.Product.DSA001;

public class InterLeavingString {
	public static void main(String[] args) {
		String n = "abcd";
		String m = "pqrst";
		
		interleavingString(n, m);
	}
	
	// tc - O(n) and sc - O(1)
	public static void interleavingString(String n, String m) {
		
		int len = Math.min(n.length(), m.length());
		
		String res = "";
		
		int i =0;
		for(; i < len; i++) {
			res += n.charAt(i)+"" + m.charAt(i)+"";
		}
		
		
		if(i < n.length()) {
			res += n.substring(i);
		}
		
		if(i < m.length()) {
			res += m.substring(i);
		}
		
		System.out.println(res);
	}
}
