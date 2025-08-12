package com.Target.Product.javastreams;

import java.util.*;

public class ToArray {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "cherry", "mango", "world");

        String[] newdata =list.stream().toArray(String[]::new);

        System.out.println(Arrays.toString(newdata));
    }
}
