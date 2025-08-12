package com.Target.Product.javastreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAny {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("mango", "banana", "cherry", "choo");

        String res = words.stream().filter(w -> w.startsWith("c")).findAny().orElse("NotFound");

        System.out.println(res);
    }
}
