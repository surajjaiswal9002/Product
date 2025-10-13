package com.Target.Product.DSA;

import java.util.Arrays;

public class MoveZerosLeft {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 0, 3};
        
        moveZerosToLeft(nums);
        
        System.out.println("After moving zeros to the left: " + Arrays.toString(nums));
    }
    
    public static void moveZerosToLeft(int[] nums) {
        int index = nums.length - 1; // Index to place non-zero elements
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                nums[index--] = nums[i];
            }
        }
        
        while (index >= 0) {
            nums[index--] = 0;
        }
    }
}

