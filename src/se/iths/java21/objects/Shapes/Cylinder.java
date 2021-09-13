package se.iths.java21.objects.Shapes;

public class Cylinder {
    private Circle base;
    private float height;

    public Cylinder(Circle base, float height) {
        this.base = base;
        this.height = height;
    }

    public Cylinder(float radius, float height){
        this.base = new Circle(radius);
        this.height = height;
    }

    public double getVolume(){
        return base.area() * height;
    }


}
