package com.Target.Product.gspdfproble;

import java.util.*;

public class KthElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

       int ans = Arrays.stream(nums).boxed().distinct()
    		   .sorted(Comparator.reverseOrder())
    		   .skip(k - 1).findFirst().orElse(-1);

       System.out.println(ans);
    }
}
