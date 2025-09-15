package com.Target.Product.designpatterns.java8;

import java.util.Arrays;
import java.util.*;

public class MaxNum {
    public static void main(String[] args) {
        int[] nums = {12, 45, 67, 87, 56};
        
        int n = Arrays.stream(nums).boxed().distinct()
        		.sorted(Comparator.reverseOrder())
        		.skip(0).findFirst().orElse(-1);
        System.out.println("-- "+n);
        
        List<Integer> list = Arrays.asList(12, 45, 67, 87, 56);
       int ans =  list.stream().sorted()
    		   .skip(1)
    		   .findFirst().orElse(-1);
       System.out.println(" using list : "+ans);
       
        
       Optional<Integer>  maxVal = list.stream().sorted().max(Integer::compare);
       System.out.println(maxVal.get());
    }
}
