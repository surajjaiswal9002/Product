package com.Target.Product.gspdfproble;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.*;
// TC - O(n) and sc - O(n)
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] ans = twoSum(nums, target);

        System.out.println(" ans : "+Arrays.toString(ans));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
