package com.Target.Product.DSA;

import java.util.LinkedHashMap;
import java.util.Stack;

public class BackspaceString {
	public static void main(String[] args) {
		
		String str = "Hello##wor#ld";
		
		System.out.println(processString(str));
	}
	
	public static String processString(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(char c : s.toCharArray()) {
			if(c == '#') {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}else {
				stack.push(c);
			}
		}
		
		
		// Build the String
		StringBuilder sb = new StringBuilder();
		for(char c : stack) {
			sb.append(c);
		}
		return sb.toString();
	}
	
	
}
