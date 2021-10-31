package se.iths.java21.randomStuff;

public class Point {
    private double x;
    private double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public static void main(String[] args) {
        Point[] points = new Point[2];
        points[0] = new Point(5.0, 10.0);
        points[1] = new Point(points[0]);
        System.out.println("x:"+ points[1].getX() + " y:" + points[1].getY());
        System.out.println("x:" + points[0].getX()
                + " y:" + points[0].getY());
    }
}
