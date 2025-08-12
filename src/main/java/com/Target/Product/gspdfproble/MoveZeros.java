package com.Target.Product.gspdfproble;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 23, 4, 0, 6};
        moveZeros(arr);
    }

    public static void moveZeros(int[] arr) {
        int k = arr.length -1 ;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                arr[k--] = arr[i];
            }
        }

         for (int i = k; i >= 0; i--) {
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));

    }
}
