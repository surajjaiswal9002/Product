package com.Target.Product.onee;

import java.util.HashMap;
import java.util.Map;


//You're given an integer array arr and a starting index start.
// Each value in the array represents the next index to jump to.
// If at any point the jump goes out of bounds (less than 0 or greater than or equal to the array length),
// the traversal stops. If a loop is detected during this traversal (i.e., you revisit an index),
// return the length of that loop. If no loop is found, return -1. The loop may or may not include
// the start index.
public class LoopDetections {
    // TC - O(N) and SC - O(N)
    public static void main(String[] args) {
        int[] arr1 = {3, 7, 4, 5, 6, 9, 10, 8, 6, 11, 12, 5, 13, 14, -1};
        int start1 = 0;

        System.out.println(" output : " + detectLoopLength(arr1, start1));

        int[] arr2 = {1, 2, 3, 4, -1};
        int start2 = 0;
        System.out.println("Output: " + detectLoopLength(arr2, start2));  // Output: -1
    }

    public static int detectLoopLength(int[] arr, int start) {
        Map<Integer, Integer> visited = new HashMap<>();
        int current = start;
        int step = 0;

        while (current >= 0 && current < arr.length) {
            if (visited.containsKey(current)) {
                // Loop detected
                return step - visited.get(current);
            }

            visited.put(current, step);
            current = arr[current];
            step++;
        }

        return -1;
    }
}
