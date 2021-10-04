package se.iths.java21.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.spi.LocaleServiceProvider;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvReader {
    private static Pattern pattern = Pattern.compile(",");//Använd pattern för att splita
    public static void main(String[] args) {
        String homePath = System.getProperty("user.home");
        Path csvPath = Path.of(homePath, "test", "cakes.csv");

        List<Cake> cakes = List.of();  //skriv inte null här, för att vi riskerar ett nullpointerexception då

        try(Stream<String> lines  = Files.lines(csvPath)){
            cakes = lines.skip(1)
                    .map(CsvReader::createCake)
                    .collect(Collectors.toList());
        }catch(IOException e){
            e.printStackTrace();
        }

        cakes.forEach(System.out::println);
    }

    private static Cake createCake(String line){
        String[] arr = pattern.split(line);
        return new Cake(Integer.parseInt(arr[0]),arr[1],Integer.parseInt(arr[2]));

    }

}
