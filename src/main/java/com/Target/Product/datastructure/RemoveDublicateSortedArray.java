package com.Target.Product.datastructure;

import java.util.Arrays;

public class RemoveDublicateSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        int n = removeDublicateSortedArr(nums);
        for (int i = 0; i < n; i++) {
            System.out.println(" remove dublicate in sorted array : " + nums[i]);
        }
    }

    public static int removeDublicateSortedArr(int[] nums) {
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}
