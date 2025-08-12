package com.Target.Product.javastreams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Skip {

    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> result = number.stream().skip(3)
                .collect(Collectors.toList());
        // OR

        List<Integer> result1 = number.stream().sorted(Comparator.reverseOrder()).skip(3)
                .collect(Collectors.toList());

        System.out.println(result);
        System.out.println(result1);
    }

}
