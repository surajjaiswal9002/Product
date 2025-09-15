package com.Target.Product.DSA;

public class ReverseString {
	public static void main(String[] args) {
		
		String s = "surajjaiswal in the product base company";
		
		reverseString(s); // tc O(n2) -- iterating + appending every time and sc - O(n);
		inBuildFunReverseString(s); // tc - O(n) and sc - O(n)
		reverseStringWithoutExtraSpace(s); // tc - O(n) and sc - O(1) - remove extra space
	}
	
	
	
	// // tc O(n2) -- iterating + appending every time and sc - O(n);
	public static void reverseString(String s) {
		int n = s.length();
		
		String rev = "";
		
		for(int i = n - 1; i >= 0; i--) {
			rev += s.charAt(i)+"";
		}
		
		System.out.println(" reverse string : "+rev);
	}
	
	
	// tc - O(n) and sc - O(n)
	public static void inBuildFunReverseString(String s) {
		StringBuilder revSB = new StringBuilder(s);
		revSB.reverse();
		
		System.out.println(" Reverse String using StringBuilder : "+revSB.toString());
	}
	
	
	//remove extra space
	// tc - O(n) and sc - O(1)
	public static void reverseStringWithoutExtraSpace(String s) {
		char ch[] = s.toCharArray();
		
		int start = 0;
		int end = ch.length - 1;
		
		while(start < end) {
			ch[start] ^= ch[end];
			ch[end] ^= ch[start];
			ch[start] ^= ch[end];
			
			++start;
			--end;
		}
		
		System.out.println(" Reverse String without extra space : "+String.valueOf(ch));
	}
	
}
