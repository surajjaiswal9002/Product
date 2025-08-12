package com.Target.Product.javastreams;

import java.util.*;
import java.util.stream.Collectors;

// Given list of list of string, flatter them into a single list of String;
public class FlatMapListofList {
    public static void main(String[] args) {

        List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("one", "two"),
                Arrays.asList("three", "four")
        );


        List<String> result = listOfList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());


        System.out.println(" result : " + result);


    }
}
