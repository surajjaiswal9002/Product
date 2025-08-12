package com.Target.Product.javastreams;

import java.util.*;
import java.util.stream.Collectors;

// removes the dublicate from the list of integer;
public class Distinct {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 4, 4, 5);

        List<Integer> result = numbers.stream().distinct().collect(Collectors.toList());
                // OR
        Set<Integer> result001 = numbers.stream().collect(Collectors.toSet());
        Set<Integer> result002 = numbers.stream().collect(Collectors.toSet());

        System.out.println(" result : " + result);
        System.out.println(" result : " + result001);
    }
}
