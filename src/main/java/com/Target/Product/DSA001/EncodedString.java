package com.Target.Product.DSA001;

public class EncodedString {
	public static void main(String[] args) {
		String s = "ABABCABABCE";
		
		encodedString(s);
	}
	
	// tc - On(n3) and sc - O(n2)
	public static void encodedString(String s) {
		int n = s.length();
		
		String[] encoded = new String[n + 1];
		encoded[0] = "";
		
		for(int i = 1; i <= n; i++) {
			encoded[i] = encoded[i - 1] + s.charAt(i - 1);
			for(int j = 1; j <= i/2; j++) {
				if(s.substring(i - 2 * j, i-j).equals(s.substring(i-j, i))) {
					String tempEncode = encoded[i - j]+"*";
					if(tempEncode.length() < encoded[i].length()) {
						encoded[i] = tempEncode;
					}
				}
			}
		}
		
		
		System.out.println(encoded[n]);
	}
}
