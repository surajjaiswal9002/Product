package com.Target.Product.javastreams;
import java.util.*;
public class Reduce {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Optional<Integer> res  = list.stream().reduce((a, b) -> a* b);

        res.ifPresentOrElse(
                val -> System.out.println(val),
                () -> System.out.println(" No found ")
        );
    }
}
