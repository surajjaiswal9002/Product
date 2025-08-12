package com.Target.Product.onee;

import java.util.Arrays;

public class MinimumRotatedSortedArr {
    public static void main(String[] args) {
        int nums[] = {5, 6, 7, 1, 2, 3, 4};

        int MRSA = findMinRotatedSortedArr(nums);
        System.out.println(MRSA);
    }

    public static int findMinRotatedSortedArr(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums[left];
    }
}
