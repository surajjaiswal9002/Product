package com.Target.Product.onee;

public class LongestCommonPrifixString {
    public static void main(String[] args) {

        String str[] = { "flower", "flow", "flight" };

        String first = str[0];
        String last  = str[str.length - 1];

        int i = 0;
        while(i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)){
            i++;
        }

        System.out.println(" Longest common prifix String : "+first.substring(0, i));
    }
}
