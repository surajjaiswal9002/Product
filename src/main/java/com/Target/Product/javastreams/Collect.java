package com.Target.Product.javastreams;
import java.util.*;
import java.util.stream.Collectors;

public class Collect {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1,1,2,5,4,6,7, 1);

        Set<Integer> result = number.stream().collect(Collectors.toSet());

        System.out.println(" result : "+result);
    }
}
