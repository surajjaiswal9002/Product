package com.Target.Product.javastreams;

import java.util.*;

public class FindFirst {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("mango", "banana", "cherry");

       Optional<String> name =  words.stream().filter(n -> n.startsWith("c")).findFirst();

       name.ifPresentOrElse(
               val -> System.out.println(" example of find first : "+val),
               () -> System.out.println(" Not found")
       );
    }
}
