package com.Target.Product.DSA001;

import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // Initialize first element of left and last element of right
        left[0] = 1;
        right[n - 1] = 1;

        // Fill left array with prefix products
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // Fill right array with suffix products
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Multiply left and right products to get the result
        for (int i = 0; i < n; i++) {
            nums[i] = left[i] * right[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);

        System.out.println("Product Except Self: " + Arrays.toString(result));
    }
}
