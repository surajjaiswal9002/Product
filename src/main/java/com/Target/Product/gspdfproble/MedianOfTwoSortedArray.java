package com.Target.Product.gspdfproble;

import java.util.*;

// Tc - O(n log n) and sc - O(n)
public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 12, 15, 26, 38};
        int[] arr2 = {2, 13, 17, 30, 45};

        int[] mergeArr = new int[arr1.length + arr2.length];

        /*for (int i = 0; i < arr1.length; i++) {
            mergeArr[i] = arr1[i];
        }*/

       /* for (int i = 0; i < arr2.length; i++) {
            mergeArr[arr1.length + i] = arr2[i];
        }*/
        System.arraycopy(arr1, 0, mergeArr, 0, arr1.length);
        System.arraycopy(arr2, 0, mergeArr, arr1.length, arr2.length);

        Arrays.sort(mergeArr);
        int n = mergeArr.length;

        int mid1 = n / 2;
        int mid2 = mid1 - 1;

        double mediam = (mergeArr[mid1] + mergeArr[mid2])  / 2.0;

        System.out.println(mediam);

    }
}
