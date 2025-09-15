package com.Target.Product.DSA001;

import java.util.Stack;

// tc - O(n) ands sc - O(n)
public class BackSpaceString {
	public static void main(String[] args) {
		String str = "Hello##wor#ld";
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '#') {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}else {
				stack.push(ch);
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(char c : stack) {
			sb.append(c);
		}
		
		System.out.println(" result : "+sb.toString());
	}
}
