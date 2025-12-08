package com.Target.Product.Java.java8;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        // Case 1: Value is present
        Optional<String> name1 = Optional.of("Suraj");

        System.out.println("Name1: " + name1.get());  // safe because value exists


        // Case 2: Value may be null → use ofNullable()
        Optional<String> name2 = Optional.ofNullable(null);

        // Avoid NullPointerException using Optional
        System.out.println("Name2: " + name2.orElse("Default Name"));


        // Case 3: Checking value before using
        if (name2.isPresent()) {
            System.out.println(name2.get());
        } else {
            System.out.println("Value not found!");
        }


        // Case 4: Using ifPresent()
        name1.ifPresent(n -> System.out.println("Uppercase: " + n.toUpperCase()));

        
        // Case 5: orElseGet() → executed only if value is null
        String result = name2.orElseGet(() -> "Generated Default Value");
        System.out.println("orElseGet: " + result);

        // Case 6: orElseThrow() → throw custom exception if null
        try {
            String data = name2.orElseThrow(() -> new IllegalArgumentException("Value is missing!"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

