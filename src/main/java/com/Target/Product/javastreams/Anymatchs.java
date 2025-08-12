package com.Target.Product.javastreams;

import java.util.Arrays;
import java.util.List;

public class Anymatchs {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0,2,3,4,5);

        boolean isTrue = list.stream().anyMatch(n -> n > 4);

        System.out.println(" isTrue : "+isTrue);
    }
}
