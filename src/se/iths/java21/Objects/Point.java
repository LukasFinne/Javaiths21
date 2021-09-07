package se.iths.java21.Objects;

public class Point {

     private int x;

     private int y;


     public Point(int x, int y) {
          this.x = x;

          this.y = y;

     }

     public double distanceTo(Point other){

          float dx = x - other.x;
          float dy = y - other.y;
          return Math.sqrt(Math.pow(dx,2) + Math.pow(dy, 2));
     }
     public static Point createPoint(){
          return new Point(0,0);
     }

     public Point(Point point){
          this.x = point.x;
          this.y = point.y;
     }


     public int getX() {
          return x;
     }

     public void setX(int x) {
          this.x = x;
     }

     public int getY() {
          return y;
     }

     public void setY(int y) {
          this.y = y;
     }

     @Override
     public String toString() {
          return "Point{" +
                  "x=" + x +
                  ", y=" + y +
                  '}';
     }
}
