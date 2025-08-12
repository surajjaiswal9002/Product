package com.Target.Product.onee;

import java.util.Arrays;

public class MissingNumberInArr {
    public static void main(String[] args) {
        int nums[] = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };

       int missingNum =  findMissingNum(nums, nums.length);
       System.out.println(" Missing Number : "+missingNum);
    }

    public static int findMissingNum(int[] nums, int n){

      int sumOfArr = Arrays.stream(nums).sum();
        return n * (n + 1) / 2 - sumOfArr;
    }
}
