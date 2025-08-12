package com.Target.Product.gspdfproble;

import java.util.*;

// TC - O(N * M) & SC - O(N * M)
public class NextGreaterElement1 {
    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] ans = findNextGreaterElement(nums1, nums2);
        System.out.println(" Nect Greater Element : " + Arrays.toString(ans));
    }

    public static int[] findNextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        System.out.println(" map : " + map);
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
