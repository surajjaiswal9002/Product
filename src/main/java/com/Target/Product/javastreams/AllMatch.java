package com.Target.Product.javastreams;

import java.util.*;

public class AllMatch {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(0,2,3,4,5);

        boolean isTrue = list.stream().allMatch(n -> n > 0);

        System.out.println(" isTrue : "+isTrue);
    }
}
