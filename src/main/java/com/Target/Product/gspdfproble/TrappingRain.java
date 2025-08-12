package com.Target.Product.gspdfproble;


// tc - O(n) and O(n)
public class TrappingRain {
    public static void main(String[] args) {

        int[] nums = {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0 };
        snowPack(nums);

    }

    public static void snowPack(int[] nums){
        int n = nums.length;

        int left[] = new int[n];
        int right[] = new int[n];

        // Left
        left[0] = nums[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i - 1], nums[i]);
        }

        //. Right
        right[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], nums[i]);
        }

        // Min find
        int snow = 0;
        for(int i = 0; i < nums.length;i++){
            snow += Math.min(left[i], right[i]) - nums[i];
        }

        System.out.println(snow);

    }
}
