package com.Target.Product.gspdfproble;

// Tc - O(log n) and sc - O(1)
public class MaximumRotatedSortedArray {

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 6 ,1, 2};

        int leftIndex = findMaxRotatedSortedArr(nums);
        int n = nums.length;

        int result = (leftIndex - 1 + n) % n;
        System.out.println(" Maximum rotated sorted array : " + nums[result]);

    }

    public static int findMaxRotatedSortedArr(int[] nums) {
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

        return left;
    }
}
