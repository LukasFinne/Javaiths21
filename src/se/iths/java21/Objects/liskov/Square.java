package se.iths.java21.Objects.liskov;

public class Square extends Rectangle{

    public Square(float sideLength){
        super(sideLength, sideLength);
    }

    @Override
    public void setWidth(float width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(float height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}
