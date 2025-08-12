package com.Target.Product.gspdfproble;


// tc - O(log(n) and sc = O(1)
class MinimumRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};

        findRotatedSortedArray(nums);
    }

    public static void findRotatedSortedArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[left] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }


        System.out.println(nums[left]);


    }
}
