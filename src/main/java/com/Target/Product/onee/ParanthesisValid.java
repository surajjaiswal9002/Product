package com.Target.Product.onee;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Stack;

public class ParanthesisValid {
    public static void main(String[] args) {
        String s = "{([])}()";

        boolean isValid = isParanthesisCheck(s);

        System.out.println(" Is paramnthesis valid : "+isValid);
    }

    public static boolean isParanthesisCheck(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() &&
                        (stack.peek() == '{' && s.charAt(i) == '}')
                        ||
                        (stack.peek() == '(' && s.charAt(i) == ')')
                        ||
                        (stack.peek() == '[' && s.charAt(i) == ']')
                ) {
                    stack.pop();
                }

            }
        }
        return stack.isEmpty();
    }
}
