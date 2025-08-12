package com.Target.Product.javastreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaxAndMin {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2,3,4,1,5,7,9);

        Optional<Integer> maxNum = list.stream().max(Integer::compareTo);

        Optional<Integer> minNum = list.stream().min(Integer::compareTo);

        System.out.println("Maximum : "+maxNum);
        System.out.println(" Minimum : "+minNum);
    }
}
