package com.Target.Product.guidewiree;

public class ConstructLongestNewString {
    public static void main(String[] args) {

        int x = 2, y = 5, z = 1;

       int ans =  longString(x, y, z);

       System.out.println(" Result : "+ans);
    }

    public static int longString(int x, int y, int z){
        int length = z * 2;

        if(x == y){
            length += x * 2 + y * 2;
        }else{
            int min = Math.min(x, y);
            length += min * 4 + 2;
        }

        return length;
    }
}
