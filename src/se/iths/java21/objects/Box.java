package se.iths.java21.objects;

public class Box {
    private int width;
    private int length;
    private int height;

    public Box(){//konstruktur
        width = 10;
    }
    public Box(int size){
        width = height = length = size;
    }

    //Används för att kopiera konstruktur
    public Box(Box box){
        width = box.width;
        length = box.length;
        height = box.height;
    }

    public Box(int width, int length, int height){
        if(width < 0 || length < 0|| height < 0)
            throw new IllegalArgumentException();
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public int getWidth(){ // med hjälp avv denna metoden kan vi skydda varaibeln
        return width;
    }

    public void setWidth(int width) {
        this.width = width;

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /* @Override
    public String toString() {//Detta behöver för att skriva ut boxens olika egenskaper, annars kunde vi inte skriva System.out.println(smallBox);
        return "Box{" +
                "width=" + width +
                ", length=" + length +
                ", height=" + height +
                '}';
    }*/
}
