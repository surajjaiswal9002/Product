package com.Target.Product.DSA;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {
	public static void main(String[] args) {
		 String s = "{[()]]";
		 
		boolean isValid =  checkValidparanthesis(s);
		System.out.println(isValid);
	}
	
	
// tc 	O(n) and sc - O(n)
	public static boolean checkValidparanthesis(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			}else {
				if(stack.isEmpty()) return false;
				
				char top = stack.pop();
				
				if(    (s.charAt(i) == ')' && top != '(') 
					|| (s.charAt(i) == '}' && top != '{') 
					|| (s.charAt(i) == ']' && top != '[')) {
					return false;
				}
			}
		}
		
		
		//HashMap<K, V>
		
		return stack.isEmpty();
	}
	
	
}	
