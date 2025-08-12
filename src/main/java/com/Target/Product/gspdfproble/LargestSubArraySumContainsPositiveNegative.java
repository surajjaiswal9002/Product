package com.Target.Product.gspdfproble;

// Tc - o(n) and sc o(1)
// kadane's Algorithm
public class LargestSubArraySumContainsPositiveNegative {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        findLargestSubArraySum(nums);
    }

    public static void findLargestSubArraySum(int[] nums) {
        int maxSumArraySum = Integer.MIN_VALUE;
        int currMax = 0;

        for(int i = 0; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSumArraySum = Math.max(maxSumArraySum, currMax);

            if (currMax < 0) {
                currMax = 0;
            }
        }


        System.out.println(" Largets max Sub Array sum contains positive and negative number : " + maxSumArraySum);
    }
}
