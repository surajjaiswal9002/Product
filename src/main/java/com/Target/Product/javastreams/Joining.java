package com.Target.Product.javastreams;

import java.util.*;
import java.util.stream.Collectors;

public class Joining {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("bananna", "mango", "apple", "grapes");

        String result = list.stream().collect(Collectors.joining(","));

        //OR
        String result1 = list.stream().collect(Collectors.joining(",","[","}"));
        System.out.println(result);
        System.out.println(result1);
    }
}
