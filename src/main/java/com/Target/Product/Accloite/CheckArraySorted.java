package com.Target.Product.Accloite;

public class CheckArraySorted {
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 10, 12};

        boolean isTrue = isSorted(arr);

        System.out.println(" Array sorted : " + isTrue);
    }

    public static boolean isSorted(int[] arr) {
        int n = arr.length;
        if (n == 0 || n == 1) {
            return true;
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
