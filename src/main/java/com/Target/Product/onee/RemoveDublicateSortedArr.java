package com.Target.Product.onee;

public class RemoveDublicateSortedArr {
    public static void main(String[] args) {

        int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

        int k = 0;

        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] != arr[i+1]){
                arr[k++] = arr[i];
            }
        }

        for(int i = 0; i < k; i++){
            System.out.print(" "+arr[i]);
        }
        System.out.println();

    }
}
