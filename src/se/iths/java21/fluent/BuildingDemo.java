package se.iths.java21.fluent;

public class BuildingDemo {
    public static void main(String[] args) {

        Building building = new BuildingBuilder().setRooms(1).setChimney(false).setPrice(10_000).createBuilding();

        building.setRooms(4);
        building.setChimney(true);
        building.setPrice(1_000_00);

        //Fluent style kallas detta, så kan man chaina ihop flera metoder
        building.setRooms(5)
                .setPrice(2_000_000)
                .setChimney(false);
        //Create object using Builder pattern
        //Avoid calling constructor with lots of parameters
        //Create Builder with Refactor -> Replace constructor with Builder.
        Building building1 = new BuildingBuilder()
                .setRooms(2)
                .setPrice(100_000)
                .createBuilding();
        //Builder pattern with convenience method.
        Building building2 = new BuildingBuilder()
                .normalBuilding()
                .createBuilding();
        //StringBuilder is an example of builder pattarn in java jdk
        //Use StringBuilder when creating strings in loops instead of +=
    }
}
