package se.iths.java21.Objects;

public class PointDemo {

    public static void main(String[] args) {
        Point point1 = new Point(3,4);
        Point point2 = new Point(1,1);
        System.out.println(point1);
        System.out.println(point2);

        System.out.println(point1.distanceTo(point2));
        //En kopia av point2
        Point point3 = new Point(point2);
        System.out.println(point3);
        System.out.println(point3.distanceTo(point2));

        Point[] points = new Point[2];
        points[0] = new Point(0,0);
        points[1] = new Point(10,10);
        for (Point point : points) {
            System.out.println(point);
        }

        Point point4 = Point.createPoint();
        point4.setX(4);
        point4.setY(2);
        System.out.println(point4);


    }
}
