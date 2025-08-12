package com.Target.Product.javastreams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DublicateNumber {
    public static void main(String[] args) {

        int[] arr = {3,2,5,6,7,81,3,5,7};

        Set<Integer> set = new HashSet<>();

       Set<Integer> dublicate =  Arrays.stream(arr).boxed().filter(n -> !set.add(n)).collect(Collectors.toSet());

        System.out.println(dublicate);
    }
}
