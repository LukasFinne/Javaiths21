package se.iths.java21.objects.Shapes;

public class Circle {
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public double area(){
        return radius * radius * Math.PI;
    }

    public double circumference(){
        return radius * 2.0 * Math.PI;
    }

}
