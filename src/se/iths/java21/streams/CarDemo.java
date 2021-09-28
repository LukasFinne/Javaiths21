package se.iths.java21.streams;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class CarDemo {//Kanske ska två separat klasser för produkterna, en productinfo med alla getters and setters och den andra med produkt metoderna

    private List<Car> cars;

    public CarDemo(){
        cars = new ArrayList<>();
    }
    public void addCar(Car car){
        //verify car before add
        cars.add(car);
    }

    public List<Car> getAllCars(){//immutable lista
        return Collections.unmodifiableList(cars);//List.copyOf(cars) funkar också
    }

    public List<Car> getCars(List<Long> ids){
        return cars.stream()
                .filter(car -> ids.contains(car.id()))
                .toList();
    }

    public List<Car> getCars(HashSet<Long> ids){//Finns flera sätt, dock den bästa är nog att använda contains metoden med ett hashset
        return cars.stream()
               // .filter(car -> ids.contains(car.id()))
                .filter(car -> ids.stream().anyMatch(id -> id == car.id()))
                .toList();
    }



    public Optional<Car> findCarById(long carId){
        return cars.stream()
                .filter(Car -> Car.id() == carId)
                .findAny();
    }
    public List<Car> findCarByBrand(String brand){
        return cars.stream()
                .filter(Car -> Car.brand().equals(brand))
                .toList(); //Eller collect(Collectors.toList());
    }
    public List<String> getListOfBrands(){
        return cars.stream()
                .map(Car::brand)
                .distinct()
                //.collect(Collectors.toSet()) //Första sättet collect(Collectors.toSet()).stream() eller kan man använda .distinct
                .toList();

    }
    public Optional<Car> lastCar(){
        return cars.stream().reduce((first, second ) -> second  );
    }

    public Optional<Car> firstCar(){
        return cars.stream().findFirst();
    }

    public Map<String, Long> getNumberByBrand(){
        return cars.stream()
                .collect(Collectors.groupingBy(Car::brand, Collectors.counting()));
    }
    public static void main(String[] args) {
        CarDemo cars = new CarDemo();
        cars.addCar(new Car(1L,"XC98", "volvo", 2021,570000));
        cars.addCar(new Car(2L,"V60", "volvo", 2021,520000));
        cars.addCar(new Car(3L,"Impreza", "Subaru", 2008,98000));
        cars.addCar(new Car(4L,"Model 3", "Tesla", 2019,472000));


        cars.getListOfBrands().forEach(System.out::println);

        HashSet<Long> ids = new HashSet<>(List.of(1L,3L));
        System.out.println(cars.getCars(ids));

        cars.lastCar().ifPresent(System.out::println);


    }

}
