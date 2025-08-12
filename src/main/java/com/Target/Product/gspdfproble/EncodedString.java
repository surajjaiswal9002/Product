package com.Target.Product.gspdfproble;


//Tc - O(n2) and sc = O(n)
public class EncodedString {
    public static void main(String[] args) {
        String str = "ABABCABABCE";
        encodedString(str);
    }

    public static void encodedString(String str) {
        int len = str.length();
        String[] encoded = new String[len + 1];

        encoded[0] = "";

        for (int i = 1; i <= len; i++) {
            encoded[i] = encoded[i - 1] + str.charAt(i - 1);
            for (int j = 1; j <= i / 2; j++) {
                if (str.substring(i - 2 * j, i - j).equals(str.substring(i - j, i))) {
                    String tempEncoded = encoded[i - j] + "*";
                    if (tempEncoded.length() < encoded[i].length()) {
                        encoded[i] = tempEncoded;
                    }
                }
            }
        }

        System.out.println(" res : " + encoded[len]);

    }
}
