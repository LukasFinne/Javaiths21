package se.iths.java21.objects;

public class VehicleDemo {
    private int passengers;
    private int fuelCap;
    private float mpg;

    /**
     *
     *
     * @param passengers
     * @param fuelCap Current fel capacity in litres. //Så här dokumenterar man sin kod för andra programmerare. Detta nog det enda tillfället när det är relevant att kommentarer i sin kod
     * @param mpg
     */


    public VehicleDemo(int passengers, int fuelCap, float mpg) {
        this.passengers = passengers;
        this.fuelCap = fuelCap;
        this.mpg = mpg;
    }

    public VehicleDemo(){
        passengers = 10;
        fuelCap = 400;
        mpg = 22;
    }

    public float computeRange(){
        return fuelCap*mpg;
    }


    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getFuelCap() {
        return fuelCap;
    }

    public void setFuelCap(int fuelCap) {
        this.fuelCap = fuelCap;
    }

    public float getMpg() {
        return mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }


    @Override
    public String toString() {
        return "VehicleDemo{" +
                "passengers=" + passengers +
                ", fuelCap=" + fuelCap +
                ", mpg=" + mpg +
                '}';
    }
}


