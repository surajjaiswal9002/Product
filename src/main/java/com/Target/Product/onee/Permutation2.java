package com.Target.Product.onee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3};

        List<List<Integer>> result = permute(nums);

        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        generatePermutation(nums, 0, result);


        return result;

    }

    public static void generatePermutation(int[] nums, int initialVal, List<List<Integer>> result) {

        if (nums.length == initialVal) {

            result.add(convertIntoList(nums));

        }

        Set<Integer> used = new HashSet<>();

        for (int i = initialVal; i < nums.length; i++) {

            if (used.contains(nums[i])) continue;

            used.add(nums[i]);

            swap(nums, initialVal, i);

            generatePermutation(nums, initialVal + 1, result);

            swap(nums, initialVal, i);
        }

    }

    public static List<Integer> convertIntoList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }

        return list;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
