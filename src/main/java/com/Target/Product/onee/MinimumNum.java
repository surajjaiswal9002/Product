package com.Target.Product.onee;

public class MinimumNum {
    public static void main(String[] args) {
        int[] nums = {12, 45, 67, 87, 56};

        findMinimumNum(nums);
    }

    public static void findMinimumNum(int[] nums){
        int minNum = Integer.MAX_VALUE;
        int secMinNum = minNum;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < minNum){
                minNum = nums[i];
            }else if(nums[i] < secMinNum && minNum != secMinNum){
                secMinNum = nums[i];
            }
        }

        System.out.println(" Minimum Number : "+minNum);
        System.out.println(" Minimum Number : "+secMinNum);
    }
}
