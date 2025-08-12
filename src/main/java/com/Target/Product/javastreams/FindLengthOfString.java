package com.Target.Product.javastreams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class FindLengthOfString {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Suraj", "hohdlJSAH", "John", "Nobita");

        OptionalInt maxLength = list.stream().mapToInt(String::length).max();

        maxLength.ifPresent(System.out::println);
    }
}
