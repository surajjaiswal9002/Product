package com.Target.Product.designpatterns.java8;

import java.util.*;

@FunctionalInterface
interface Calculator {


    int add(int a, int b);  // single abstract method

    default int multiply(int a, int b) {
        return a * b;
    }

  
}

public class LambdaExpression {
    public static void main(String[] args) {

        Calculator c = (a, b) -> a + b;

        System.out.println(c.add(10, 30));

        List<String> list = Arrays.asList("mango", "apple", "coconuts", "banana");

        list.forEach(n -> System.out.print(n + ", "));
        System.out.println(" \n Alternate way ***** ");
        list.forEach(System.out::println);



        int multiplication = c.multiply(60, 2);
        System.out.println(" multiplication : " + multiplication);

        int subStract = Calculator.substract(10, 5);

        System.out.println(subStract);
    }


}
