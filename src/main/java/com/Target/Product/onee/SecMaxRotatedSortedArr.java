package com.Target.Product.onee;

public class SecMaxRotatedSortedArr {
    public static void main(String[] args) {

        int nums[] = {5, 6, 7, 1, 2, 3, 4};
        int n = nums.length;

        int leftIndex = findMaxRotatedSortedArr(nums);

        int maxIndex = (leftIndex - 1 + n) % n;

        if(maxIndex == 0){
            System.out.println(nums[n - 1]);
        }else{
            System.out.println((nums[maxIndex - 1]));
        }
    }

    public static int findMaxRotatedSortedArr(int[] nums){
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
