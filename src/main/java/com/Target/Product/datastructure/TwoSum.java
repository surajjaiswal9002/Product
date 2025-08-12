package com.Target.Product.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
       int[] nums = {2, 7, 11, 15};
        int target = 9;


        int[] ans = findTwoSum(nums, target);

        System.out.println(" ans : "+ Arrays.toString(ans));  // 0, 1
    }

    public static int[] findTwoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length;i++){
            int comp = target - nums[i];

            if(map.containsKey(comp)){
                System.out.println(map);
                return new int[] {map.get(comp), i};
            }

            map.put(nums[i], i);
        }



        return new int[] {-1, -1};
    }
}
