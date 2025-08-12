package com.Target.Product.gspdfproble;

//TC - O(n) and sc = O(1);
public class ReverseString02 {
    public static void main(String[] args) {
        String s = "hello";

        int start = 0;
         int end = s.length() - 1;

         char ch[] = s.toCharArray();

         while(start < end){
             char temp = ch[start];
             ch[start] = ch[end];
             ch[end] = temp;

             start++;
             end--;
         }


         System.out.println(" reverse : "+String.valueOf(ch));
    }
}
