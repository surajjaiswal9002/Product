package com.Target.Product.gspdfproble;

public class MedianOfSortedArr {
    public static void main(String[] args) {

        int[] arr1 = {1, 3};
        int[] arr2 = {2};

        double ans = medianSortedArr(arr1, arr2);
        System.out.println(" result : " + ans);
    }

    public static double medianSortedArr(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int low = 0;  // Math.max(0, k - m);
        int high = n;  // Math.min(k, n)

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n + m + 1) - cut1;   // k - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int r1 = (cut1 == n) ? Integer.MAX_VALUE : arr1[cut1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r2 = (cut2 == m) ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                // median logic
                if ((n + m) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }

            } else if (l1 > l2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return -1;
    }
}
