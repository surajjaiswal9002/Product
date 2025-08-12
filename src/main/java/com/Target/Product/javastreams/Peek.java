package com.Target.Product.javastreams;

import java.util.*;
import java.util.stream.Collectors;

public class Peek {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("bananan", "cherry", "mango");

        List<String> result = fruits.stream()
                .peek(fruit -> System.out.println(" Original word : "+fruit))
                .map(String::toUpperCase)
                .peek(fruit -> System.out.println(" Original word changed : "+fruit))
                .collect(Collectors.toList());

        System.out.println( result);
    }
}
