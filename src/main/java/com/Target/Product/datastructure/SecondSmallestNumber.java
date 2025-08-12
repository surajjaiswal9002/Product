package com.Target.Product.datastructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SecondSmallestNumber {
    public static void main(String[] args) {

        int[] arr = {7, 3, 5, 6, 7, 8, 2};

        System.out.println(" 2nd Smallest Number Java 8 : " + secSmallestNumber(arr));
        System.out.println(" 2nd Largest Number Java 8 : " + secLargestNumber(arr));

    }



    public static int secSmallestNumber(int[] arr) {

        int secNum = Arrays.stream(arr).boxed().sorted().skip(1).findFirst().orElse(-1);

        return secNum;
    }

    public static int secLargestNumber(int[] arr) {

        int secNum = Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);

        return secNum;
    }
}
