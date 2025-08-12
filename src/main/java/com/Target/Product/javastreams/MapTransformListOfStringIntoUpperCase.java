package com.Target.Product.javastreams;

import java.util.*;
import java.util.stream.Collectors;

// Transform list of string into a list of their uppercase version
public class MapTransformListOfStringIntoUpperCase {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "mango", "banana", "mango");

        Set<String> result = words.stream()
                .map(String::toUpperCase).collect(Collectors.toSet());

        System.out.println(" result : "+result);
    }
}
