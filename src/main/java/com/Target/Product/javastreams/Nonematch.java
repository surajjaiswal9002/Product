package com.Target.Product.javastreams;

import java.util.Arrays;
import java.util.List;

public class Nonematch {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        boolean isTrue = list.stream().noneMatch(n -> n < 0);

        System.out.println(" isTrue : "+isTrue);
    }
}
