package se.iths.java21.exercises.streams;

import java.util.Comparator;
import java.util.List;

public class Countries {//flat map

    public static void main(String[] args) {

        List<Country> countries = getCountries();

       // task2(countries);
        //task3(countries);
       // task4(countries);
        //task5(countries);
       // task6(countries);
       // task8(countries);
        task9(countries);
    }



    private static void task2(List<Country> countries){
        countries.stream()
                .findFirst()
                .map(Country::countryName)
                .ifPresent(System.out::println);

        countries.stream()
                .reduce((first, second) -> second)
                .map(Country::countryName)
                .ifPresent(System.out::println);
    }
    private static void task3(List<Country> countries){
        countries.stream()
                .map(Country::countryName)
                .sorted()
                .toList().forEach(System.out::println);
    }
    private static void task4(List<Country> countries){
        countries.stream()
                .sorted(Comparator.comparing(Country::population).reversed())
                .map(Country::countryName)
                .forEach(System.out::println);
    }
    private static void task5(List<Country> countries){
        countries.stream()
                .mapToDouble(Country::population)
                .max()
                .ifPresent(System.out::println);
    }
    private static void task6(List<Country> countries){
        double averageArea = countries.stream()
                .mapToDouble(Country::area)
                .average()
                .orElse(0.0);

        System.out.println(countries.stream()
                .filter(country -> country.area() > averageArea)
                .count());
    }
    private static void task7(List<Country> countries){
        countries.stream()
                .filter(country -> country.population() < 5)
                .map(Country::countryName)
                .forEach(System.out::println);
    }
    private static void task8(List<Country> countries) {
        System.out.println(countries.stream()
                .filter(country -> country.area() > 10000).count());
        System.out.println(countries.stream()
                .filter(country -> country.area() > 10000).count());
        System.out.println(countries.stream()
                .filter(country -> country.area() > 10000).count());
    }
    private static void task9(List<Country> countries){
        countries.stream()
                .filter(country -> country.countryName().startsWith(String.valueOf(country.capital().charAt(0))))
                .map(Country -> new CountryAndCapital(Country.countryName(), Country.capital()))
                .forEach(System.out::println);
    }
    record CountryAndCapital(String CountryName, String Capital){} //Gör detta i min lab2v2
    private static void task10(List<Country> countries){
        countries.stream()
                .filter(country -> country.countryName().length() > country.capital().length())
                .map(Country::countryName)
                .forEach(System.out::println);
    }
    private static void task11(List<Country> countries){
        countries.stream()
                .sorted(Comparator.comparing(Country::population))
                .map(Country::countryName)
                .limit(5)
                .forEach(System.out::println);
    }
    private static void task12(List<Country> countries){
        countries.stream()
                .filter(country -> country.population() > 7.0)
                .sorted(Comparator.comparingDouble(Country::population))
                .map(Country::countryName)
                .limit(3)
                .forEach(System.out::println);
    }




        private static List<Country> getCountries() {
        return List.of(
                new Country("Sverige", "Stockholm", 10.07, 450295),
                new Country("Norge", "Oslo", 5.27, 323802),
                new Country("Island", "Reykjavik", 0.33, 102775),
                new Country("Danmark", "Köpenhamn", 5.75, 42931),
                new Country("Finland", "Helsinki", 5.51, 338424),
                new Country("Belgien", "Bryssel", 11.30, 30528),
                new Country("Tyskland", "Berlin", 82.18, 357168),
                new Country("Frankrike", "Paris", 66.99, 640679),
                new Country("Storbritannien", "London", 60.80, 209331),
                new Country("Niue", "Alofi", 0.0016, 261),
                new Country("Mongoliet", "Ulan Batar", 3.08, 1566000),
                new Country("Niue", "Alofi", 0.0016, 261),
                new Country("Polen", "Warszawa", 38.63, 312679),
                new Country("Spanien", "Madrid", 46.5, 505990),
                new Country("Portugal", "Lissabon", 10.31, 92212),
                new Country( "Italien", "Rom", 60.59, 301338),
                new Country( "Grekland", "Aten", 11.18, 131957),
                new Country(  "Luxemburg", "Luxemburg", 0.58, 2586),
                new Country(  "Liechtenstein", "Vaduz", 0.038, 160));
    }
}
