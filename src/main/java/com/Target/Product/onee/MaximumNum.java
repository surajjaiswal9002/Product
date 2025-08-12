package com.Target.Product.onee;

public class MaximumNum {
    public static void main(String[] args) {
        int[] nums = {12, 45, 67, 87, 56};

        findMaxNum(nums);
    }

    public static void findMaxNum(int[] nums) {
        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
            }
        }

        System.out.println("Maximum Number : " + maxNum);
    }
}
