package com.Target.Product.DSA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArrayIncreasingFreq {
	public static void main(String[] args) {
		
		 //int[] nums = {1, 1, 2, 2, 2, 3};  // Output: [3,1,1,2,2,2]
        int[] nums = {2, 3, 1, 3, 2};       // Output: [1,3,3,2,2]
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
        	map.put(num, map.getOrDefault(num, 0)+1);
        }
       
       
        System.out.println( " map : "+map);
        
        Integer arr[] = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        
        Arrays.sort(arr, (a, b) -> {
        	int a1 = map.get(a);
        	int b1 = map.get(b);
        	
        	if(a1 == b1) {
        		return Integer.compare(b, a);
        	}
        	
        	return Integer.compare(a1, b1);
        });
        
        System.out.println(" Sort Array Increasing Frequency : "+Arrays.toString(arr));
	}
}
