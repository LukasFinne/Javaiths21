package se.iths.java21.objects;

public class Main {


    public static void main(String[] args) {
        VehicleDemo vehicleDemo = new VehicleDemo(4,20,100);

        vehicleDemo.setPassengers(4);

        System.out.println(vehicleDemo.getPassengers());

        vehicleDemo.setFuelCap(5);
        vehicleDemo.setMpg(4);
        System.out.println(vehicleDemo.computeRange());

        VehicleDemo vehicleDemo2 = new VehicleDemo();

        System.out.println(vehicleDemo2.getPassengers());
        System.out.println(vehicleDemo2.computeRange());

        System.out.println(vehicleDemo);

    }


}
