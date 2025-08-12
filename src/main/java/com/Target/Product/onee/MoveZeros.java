package com.Target.Product.onee;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12, 0};

        int ans[] = moveZerosAtLast(nums, nums.length);
    }

    public static int[] moveZerosAtLast(int[] nums, int n) {
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        // add zeros
        for (int i = k; i < n; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
        return new int[]{-1, -1};
    }
}
