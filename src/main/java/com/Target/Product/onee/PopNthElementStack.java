package com.Target.Product.onee;

import java.util.Stack;

public class PopNthElementStack {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.add(10);
        stack.add(20);
        stack.add(30);
        stack.add(40);
        stack.add(50);

        int n = 3;

        System.out.println(" Before : " + stack);
        popNthElement(stack, n);
        System.out.println(" After : " + stack);

    }

    public static void popNthElement(Stack<Integer> stack, int n) {
        if (n == 1) {
            stack.pop();
            return;
        }

        int top = stack.pop();

        popNthElement(stack, n - 1);

        stack.push(top);
    }
}
