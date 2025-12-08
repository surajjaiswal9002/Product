package com.Target.Product.Java.java8;

import java.util.*;

// Functional Interface - contains ONLY one abstract method
@FunctionalInterface
interface Calculator {

    // Single Abstract Method (SAM)
    int add(int a, int b);

    // Default method - introduced in Java 8
    default int multiply(int a, int b) {
        return a * b;
    }

    // Static method inside interface (Java 8 feature)
    static int substract(int a, int b) {
        return a - b;
    }
}

public class LambdaExpression {
    public static void main(String[] args) {

        // Lambda Expression to implement the abstract method 'add()'
        // No method name, no return type, no modifiers → Anonymous function
        Calculator c = (a, b) -> a + b;

        // Calling the abstract method through lambda expression
        System.out.println("Addition: " + c.add(10, 30));

        // List of fruits
        List<String> list = Arrays.asList("mango", "apple", "coconuts", "banana");

        // Using lambda expression with forEach() to iterate list
        list.forEach(n -> System.out.print(n + ", "));

        System.out.println("\nAlternate way (Method Reference) ***** ");

        // Method Reference - short form of lambda
        list.forEach(System.out::println);

        // Calling default method of interface
        int multiplication = c.multiply(60, 2);
        System.out.println("Multiplication: " + multiplication);

        // Calling static method of interface
        int subStract = Calculator.substract(10, 5);
        System.out.println("Subtraction: " + subStract);
    }
}
