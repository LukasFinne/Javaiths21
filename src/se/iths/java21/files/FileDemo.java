package se.iths.java21.files;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class FileDemo {

    public static void main(String[] args) throws IOException {
        String homeFolder = System.getProperty("user.home");
        Path path = Path.of(homeFolder, "test", "fil1.txt");
        Files.createDirectories(path.getParent());
        System.out.println(Files.exists(path));
        System.out.println(path.toAbsolutePath());

       // byte [] bytes = ByteBuffer.allocate(4).putInt(123456789).array(); Om man skrev tal med writeString metoden så tar det 9 byte men med detta så tar det bara 4 byte
        //Path binary = Files.createTempFile("some", ".bin");
       // Files.write(binary, bytes);
       // System.out.println("tempBinaryFile = " + binary);


        //List<String> strings = List.of("First Line", "Second", "Third");
       // Files.write(path, strings, StandardOpenOption.APPEND, StandardOpenOption.CREATE);

        System.out.println(Files.exists(path));

        //String s = Files.readString(path);
        //System.out.println( s);
        //List<String> stringList = Files.readAllLines(path);
        // stringList.forEach(System.out::println);

        Stream<String> stream = Files.lines(path);
        stream.filter(i -> i.startsWith("F"))
                .forEach(System.out::println);

    }
}
