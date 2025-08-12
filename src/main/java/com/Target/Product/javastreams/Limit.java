package com.Target.Product.javastreams;

import java.util.*;
import java.util.stream.*;

public class Limit {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

       List<Integer> result =  number.stream().limit(3)
                .collect(Collectors.toList());


       System.out.println( result );
    }
}
