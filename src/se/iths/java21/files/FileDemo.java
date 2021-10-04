package se.iths.java21.files;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileDemo {

    public static void main(String[] args) {
        Path path = Path.of("~", "test", "fil1.txt" );
        System.out.println(Files.exists(path));
    }
}
