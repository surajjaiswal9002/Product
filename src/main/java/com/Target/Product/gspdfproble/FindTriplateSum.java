package com.Target.Product.gspdfproble;

import java.util.Arrays;

// tc O(n2) and O(1)
public class FindTriplateSum {
    public static void main(String[] args) {

        int[] nums = {12, 3, 4, 1, 6, 9};
        int sum = 24;

        int[] ans = triplateSum(nums, sum);

        System.out.println(" Triplate sum : " + Arrays.toString(ans));
    }

    public static int[] triplateSum(int[] nums, int sum) {
        // sort
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int tempSum = nums[i] + nums[left] + nums[right];
                if (tempSum == sum) {
                    return new int[]{nums[i], nums[left], nums[right]};
                } else if (tempSum < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new int[]{-1, -1, -1};
    }
}
