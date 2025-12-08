package com.Target.Product.Gold;

public class CheckPalindrume {
	public static void main(String[] args) {
		
		String input = "Ra@ce!ca r";
		String input1 = "RaceCar";
		// tc - O(n) and sc - (n)
		boolean isTrue = checkPalindrume(input);
		System.out.println(isTrue);
		
		boolean isItPall =  isPalindrume(input1);
		
		System.out.println(isItPall);
		
		
	}
	
	// tc - O(n) and sc - O(1)
	public static boolean isPalindrume(String s) {
		
		int left = 0;
		int right = s.length() - 1;
		
		while(left < right) {
			
			// skip non letter character
			while(left < right && !Character.isLetter(s.charAt(left))) {
				left++;
			}
			
			while(left < right && !Character.isLetter(s.charAt(right))) {
				right--;
			}
			
			if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
	
	public static boolean checkPalindrume(String s) {
		
		String newString = "";
		
		for(int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				newString += c+"";
			}
		}
		
		
		String rev = new StringBuilder(newString).reverse().toString();
		
		System.out.println(newString);
		System.out.println(rev);
		return newString.toLowerCase().equals(rev.toLowerCase());
	}
}	
