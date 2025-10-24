package com.Target.Product.Java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReadWriteUsingCount {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("demo.txt");

        // Write sample content to file
        Files.writeString(path, "Hello Java 11!\nThis is a demo file.\nCount lines and words.");

        // ✅ Read all content as string
        String content = Files.readString(path);
        System.out.println("File Content:\n" + content);

        // ✅ Count characters
        long charCount = content.length();

        // ✅ Count words (split by space)
        long wordCount = Stream.of(content.split("\\s+"))
                               .filter(word -> !word.isBlank())
                               .count();

        // ✅ Count lines
        long lineCount = Files.lines(path).count();

        System.out.println("\n--- File Statistics ---");
        System.out.println("Lines: " + lineCount);
        System.out.println("Words: " + wordCount);
        System.out.println("Characters: " + charCount);
    }
}

