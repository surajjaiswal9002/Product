package com.Target.Product.DSA;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubSequence {
	
	
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		int res = lengthOfLIS(nums);
		System.out.println(" L I S -  "+res);
	}
	
	//tc  o(n) ans sc - O(n)
    public static int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for (int n : nums) {
            if (res.isEmpty() || res.get(res.size() - 1) < n) {
               	res.add(n);
            } else {
                int idx = binarySearch(res, n);            
                res.set(idx, n);
        
            }
        }

        return res.size();        
    }

    
    // tc - O(log n) and sc = O(1)
    private static int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) < target) {
                left = mid +1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left+" ooo ");
        return left;
    }    
}