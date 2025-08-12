package com.Target.Product.Accloite;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] anss = twoSum(nums, target);
        System.out.println(" ans : "+ Arrays.toString(anss));
    }

    public static int[] twoSum(int[] nums, int t){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complementry = t - nums[i];

            if(map.containsKey(complementry)){
                return new int[]{map.get(complementry), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{nums[0], 0};
    }
}
