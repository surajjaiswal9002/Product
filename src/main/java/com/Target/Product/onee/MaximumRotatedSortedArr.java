package com.Target.Product.onee;

public class MaximumRotatedSortedArr {
    public static void main(String[] args) {
        int nums[] = {5, 6, 7, 1, 2, 3, 4};
        int n = nums.length;

        int LeftIndex = findMaxRotatedSortedArr(nums);

        int maxIndex = (LeftIndex - 1 + n) % n;

        System.out.println(nums[maxIndex]);


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
