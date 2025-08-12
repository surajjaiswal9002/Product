package com.Target.Product.Accloite;

public class CountZerosInBinary {
    public static void main(String[] args) {

        int n = 4;

        String binary = Integer.toBinaryString(n);
        System.out.println(" Binary : " + binary);

        int count = 0;
        for (char ch : binary.toCharArray()) {
            if (ch == '0') {
                count++;
            }
        }
        System.out.println(" Number of zeros : " + count);
    }
}
