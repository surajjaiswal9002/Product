package com.Target.Product.onee;

public class LongestContinueIncreaseSubSeq {
    public static void main(String[] args) {

        int[] nums = {1,3,5,4,7};

       int lcis =  findLCIS(nums);

       System.out.println(" Longest Continue Increasing SubSequence : "+lcis);
    }

    public static int findLCIS(int[] nums){
        int maxSubSeq = Integer.MIN_VALUE;
        int count = 1;

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i + 1]){
                count++;
            }else{
                maxSubSeq = Math.max(maxSubSeq, count);
                count = 1;
            }
        }

        return maxSubSeq;
    }


}
