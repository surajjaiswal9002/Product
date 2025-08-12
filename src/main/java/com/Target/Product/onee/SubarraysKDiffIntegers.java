package com.Target.Product.onee;

import java.util.HashMap;
import java.util.Map;

public class SubarraysKDiffIntegers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;

        int ans = findSubArrKDiffUInt(nums, k);
        System.out.println(ans);
    }

    public static int findSubArrKDiffUInt(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < nums.length - 1; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() > k){
                map.put(nums[left], map.get(nums[left] - 1));
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return  maxLen;
    }
}
