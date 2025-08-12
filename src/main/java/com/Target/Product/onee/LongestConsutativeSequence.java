package com.Target.Product.onee;

import java.util.HashSet;
import java.util.Set;

public class LongestConsutativeSequence {
    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        int LongConsutativeSeq = longestConsutative(nums);

        System.out.println(" longest consutative sequence : " + LongConsutativeSeq);


    }

    public static int longestConsutative(int[] nums) {

        if (nums.length == 0 || nums == null) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }


        System.out.println(" longest consutative : " + set);
        int maxLength = 0;

        for (int num : set) {
            System.out.println(" longest : " + set.contains(num - 1));
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currLength = 1;

                while (set.contains(currNum + 1)) {
                    currNum++;
                    currLength++;
                }

                maxLength = Math.max(maxLength, currLength);
            }
        }

        return maxLength;
    }
}
