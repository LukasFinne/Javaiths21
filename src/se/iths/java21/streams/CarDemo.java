package se.iths.java21.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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

    }

    public static void main(String[] args) {
        CarDemo cars = new CarDemo();
        cars.addCar(new Car(1L,"xc98", "volvo", 2021,570000));
        cars.addCar(new Car(2L,"V60", "volvo", 2021,520000));
        cars.addCar(new Car(3L,"Impreza", "Subaru", 2008,98000));
        cars.addCar(new Car(4L,"Model 3", "Tesla", 2019,472000));
    }

}
