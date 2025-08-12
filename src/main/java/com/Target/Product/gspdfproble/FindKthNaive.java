package com.Target.Product.gspdfproble;


// Tc - O(k) and sc - O(1)
public class FindKthNaive {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;
        int result = findKthElement(arr1, arr2, k);
        System.out.println("Kth element is: " + result);
    }

    public static int findKthElement(int[] arr1, int[] arr2, int k) {
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < arr1.length && j < arr2.length) {
            int tempVal;
            if (arr1[i] < arr2[j]) {
                tempVal = arr1[i++];
            } else {
                tempVal = arr2[j++];
            }

            count++;
            if (count == k) return tempVal;
        }


        while (i < arr1.length) {
            count++;
            if (count == k) return arr1[i];
            i++;
        }

        while (i < arr2.length) {
            count++;
            if (count == k) return arr2[i];
            i++;
        }

        return -1;
    }
}
