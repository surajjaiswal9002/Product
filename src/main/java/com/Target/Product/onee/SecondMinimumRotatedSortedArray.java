package com.Target.Product.onee;

public class SecondMinimumRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = { 5, 6, 7, 1, 2, 3, 4 };

       int leftIndex =  findMinSortedArr(nums);
        int n = nums.length;

       int secondMinRotatedSortedArr = nums[leftIndex + 1] % n;
       System.out.println(secondMinRotatedSortedArr);
    }

    public static int findMinSortedArr(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }
}
