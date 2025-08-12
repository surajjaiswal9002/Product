package com.Target.Product.gspdfproble;

import java.util.Collections;
import java.util.PriorityQueue;


// O(n log n) and sc = O(n)
public class XOROprationFindK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int n = 3;
        int k = 2;

        int maxKXOR = getMaxXORBasedOnK(nums, n, k);

        System.out.println(" Max K xor : " + maxKXOR);
    }

    public static int getMaxXORBasedOnK(int[] nums, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            int xor = num ^ k;
            pq.offer(xor);
        }

        int maxKXOR = 0;
        for (int i = 0; i < k; i++) {
            maxKXOR += pq.poll();
        }

        return maxKXOR;
    }


}
