package com.Target.Product.Accloite;

import java.util.Arrays;
import java.util.*;
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {12, 3, 4, 1, 6, 9};
        int sum = 24;

        int[] triplateSum = triplateSum(nums, sum);
        System.out.println(" ansd : "+Arrays.toString(triplateSum));
    }

    public static int[] triplateSum(int[] nums, int t){
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int currSum = nums[i] + nums[left] + nums[right];
                if(currSum == t){
                    return new int[] {nums[i], nums[left], nums[right]};
                }else if (currSum < t){
                    left++;
                }else{
                    right--;
                }
            }
        }


        return new int[]{-1, -1};
    }
}
