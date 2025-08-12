package com.Target.Product.gspdfproble;

import java.util.HashSet;
import java.util.Set;

public class CyclicLength {
    public static void main(String[] args) {
        int[] arr = {1, 0};
        int startIndex = 0;

        int ans = getCyclicLength(arr, startIndex);
        System.out.println(ans);
    }

    public static int getCyclicLength(int[] arr, int index) {
        Set<Integer> visited = new HashSet<>();
        int curr = index;
        int start = 0;

        while (!visited.contains(curr)) {
            if (curr < 0 && curr >= arr.length) {
                return -1;
            }

            visited.add(curr);
            curr = arr[curr];
            start++;
        }

        return start;
    }
}
