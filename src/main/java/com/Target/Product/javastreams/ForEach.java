package com.Target.Product.javastreams;

import java.util.*;

public class ForEach {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "mango", "cherry");

        words.stream().forEach(w -> System.out.println("Item : "+w));

    }
}
