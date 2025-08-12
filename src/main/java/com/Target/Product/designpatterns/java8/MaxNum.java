package com.Target.Product.designpatterns.java8;

import java.util.Arrays;
import java.util.Comparator;

public class MaxNum {
    public static void main(String[] args) {
        int[] nums = {12, 45, 67, 87, 56};

        int n = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).skip(0).findFirst().orElse(-1);

        System.out.println(n);
    }
}
