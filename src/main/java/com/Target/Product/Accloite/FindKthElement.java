package com.Target.Product.Accloite;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class FindKthElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        Optional<Integer> kthElement = Arrays.stream(nums)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder()).skip(k - 1).findFirst();

        kthElement.ifPresentOrElse(
                (v) -> System.out.println(v),
                () -> System.out.println("Not found")
        );
    }
}
