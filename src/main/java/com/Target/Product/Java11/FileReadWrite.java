package com.Target.Product.Java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


//Files.readString() and Files.writeString()

//Simplifies reading and writing files as strings (no need for BufferedReader or FileWriter).
public class FileReadWrite {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("demo.txt");
        Files.writeString(path, "Hello, Java 11!");

        String content = Files.readString(path);
        System.out.println(content); // Output: Hello, Java 11!
        
        
//        Creates a file demo.txt (if not exists).
//
//        Writes "Hello, Java 11!".
//
//        Reads it back.
//
//        Prints it.
    }
}
