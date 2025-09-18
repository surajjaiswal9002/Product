package com.Target.Product.DSA001;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	public static void main(String[] args) {
		int n = 3;
		
		List<String> list = genetatePraanthesis(n);
		System.out.println(list);
	}
	
	public static List<String> genetatePraanthesis(int n){
		List<String> result = new ArrayList<String>();
		
		backTrack(result, "", 0, 0, n);
		
		return result;
	}
	
	
	//O(m * N) and s c = O(m * N)
	public static void backTrack(List<String> result, String current, int open, int close, int max) {
		//base case
		if(current.length() == max * 2) {
			result.add(current);
			return;
		}
		
		// (
		if(open < max) {
			backTrack(result, current+"(", open + 1, close, max);
		}
		
		//)
		if(close < open) {
			backTrack(result, current+")", open, close + 1, max);
		}
	
	}
}
