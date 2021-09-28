package se.iths.java21.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static se.iths.java21.streams.Sex.*;

public class StreamDemo {

    public static void main(String[] args) {
        //Använd list för att göra en kategori,och inuti listorna är produkterna
        //Check out list of lists
        List<PersonR> persons = getPersonRList();

        persons.forEach(System.out::println);
        System.out.println("======");
        List<PersonR> otherPersons = getPersonsOverAge30(persons);

        otherPersons.forEach(System.out::println);

        long count = getCountOfPersonsYoungerThan15(persons);
        System.out.println(count);

        int ageSum = getSumOfAges(persons);
        System.out.println(ageSum);

        Stream<PersonR> personRStream = persons.stream() // Man kan ange en variabel till koden och senare skriva ut stream med en foreach
                .peek(personR -> System.out.println("Peek before filter: " + personR))
                .filter(personR ->  personR.age() > 10);


        personRStream.forEach(System.out::println);

        Stream.iterate(0,n -> ++n)
                .limit(100)
                .filter(i -> i %2 == 0)
                .forEach(System.out::println);
        persons.stream().sorted(Comparator.comparingInt(PersonR::age)).forEach(System.out::println);
    }

    private static Optional<PersonR> getPersonWithName(List<PersonR> persons, String name){
       return persons.stream()
               .filter(personR -> personR.name().equals(name))
               .findAny();
    }

    private static int getSumOfAges(List<PersonR> persons) {
        return persons.stream().mapToInt(personR -> personR.age()).sum();
    }

    private static long getCountOfPersonsYoungerThan15(List<PersonR> persons) {
        return persons.stream().filter(personR -> personR.age() < 15).count();
    }

    private static List<PersonR> getPersonsOverAge30(List<PersonR> persons) {
        List<PersonR> otherPersons = persons.stream()
                .filter(personR -> personR.age() > 30)
                .collect(Collectors.toList());
        return otherPersons;
    }

    private static List<PersonR> getPersonRList() {
        List<PersonR> persons = List.of(
                new PersonR("Martin", 44, MALE, true),
                new PersonR("Anna", 32, FEMALE, false),
                new PersonR("Elisabeth", 12, FEMALE, false),
                new PersonR("Sven", 24, OTHER, true));
        return persons;


        §

    }


}
