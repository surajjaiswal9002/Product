package com.Target.Product.DSA001;

import java.util.Arrays;

public class MoveZerosRight {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        
        moveZerosToRight(nums);
        
        System.out.println("After moving zeros to the right: " + Arrays.toString(nums));
    }
    
    public static void moveZerosToRight(int[] nums) {
        int index = 0; // Index to place non-zero elements
        
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}

