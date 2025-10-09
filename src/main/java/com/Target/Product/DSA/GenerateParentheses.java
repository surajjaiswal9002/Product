package com.Target.Product.DSA;

import java.util.*;

public class GenerateParentheses {
	
	
	// tc - O(n) and sc = O(n)
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    
    
    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: if the current string is complete
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Add '(' if we still have some left
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Add ')' if it won't break validity
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println(result);
    }
}

