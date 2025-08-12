package com.Target.Product.JJava11;

public class NewStringMethod {
    public static void main(String[] args) {

        System.out.println(" ".isBlank());           // true
        System.out.println("Line1\nLine2".lines().count()); // 2
        System.out.println("  hello ".strip());        // "hello"
        System.out.println("ha".repeat(3));            // "hahaha"
    }
}
