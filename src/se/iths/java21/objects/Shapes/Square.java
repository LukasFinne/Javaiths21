package se.iths.java21.objects.Shapes;

public class Square {
    private float side;



    public Square(float side) {
        this.side = side;
    }
    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }
    public double area(){
        return side * side;
    }

    public double perimeter(){
        return side * 4.0;
    }


}
