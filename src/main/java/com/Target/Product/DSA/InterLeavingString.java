package com.Target.Product.DSA;


// tc 
public class InterLeavingString {
	public static void main(String[] args) {
		
		String a = "abc";
		String b = "pqrst";

		
		findInterLeavingString(a, b);
	}
	
	
	// tc - o(n + m) and sc - O(n + m)
	public static void findInterLeavingString(String a, String b) {
		String ans  = "";
		int minLength = Math.min(a.length(), b.length());
		
		int i = 0;
		for(; i < minLength; i++) {
			ans += a.charAt(i)+"" + b.charAt(i)+"";
		}
		
		if(i < a.length()) {
			ans += a.substring(i);
		}
		
		if(i < b.length()) {
			ans += b.substring(i);
		}
		
		
		System.out.println(" Inter Leaving String : "+ans);
		
	}
}
