package com.Target.Product.Java.java8;

import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        numbers.stream()
                .filter(n -> {
                    System.out.println("Filtering: " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("Mapping: " + n);
                    return n * n;
                })
                .limit(2)
                .forEach(System.out::println);
    }
}

