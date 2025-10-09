package com.Target.Product.DSA001;

import java.util.Stack;

public class DecodeString {
	public static void main(String[] args) {
		String str = "3[a2[c]]";
		
		decodeString(str);
	}
	
	// tc - O(n *k) and sc (n)
	public static void decodeString(String s) {
		Stack<Integer> countStack = new Stack<Integer>();
		Stack<StringBuilder> stringStack = new Stack<StringBuilder>();
		StringBuilder currentString = new StringBuilder();
		int currentNum = 0;
		
		for(char c : s.toCharArray()) {
			if(Character.isDigit(c)) {
				currentNum = currentNum * 10 + (c - '0');
			}else if(c == '[') {
				countStack.push(currentNum);
				stringStack.push(currentString);
				currentNum = 0;
				currentString = new StringBuilder();
			}else if(c == ']'){
				int remainingCount = countStack.pop();
				StringBuilder decode = stringStack.pop();
				for(int i = 0; i < remainingCount; i++) {
					decode.append(currentString);
				}
				currentString = decode;
			}else {
				currentString.append(c);
			}
		}
		
		System.out.println(" Decode String : "+currentString.toString());
	}
}
