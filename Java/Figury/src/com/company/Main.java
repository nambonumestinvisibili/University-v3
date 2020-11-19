package com.company;

public class Main {

    public static void main(String[] args) {

        Line line = new Line(-1, 1, 0);    //y = x
        Point zero = new Point(0,0);
        Vector vec = new Vector(2,3);
        double ninetydegrees = 1.57079633;

        //Point
        Point p1 = new Point(1,1);
        p1.reflect(line);                           //p1 should not be changed
        System.out.println(p1);
        p1.rotate(zero, ninetydegrees);
        System.out.println(p1);                     //rotated by 90 degrees about (0,0)
        p1.move(vec);
        System.out.println(p1);

        p1 = new Point(1,1);
        Point p2 = new Point(2,2);

        //Line segment
        //LineSegment segmentx = new LineSegment(p1, p1); //raises an error
        LineSegment segment = new LineSegment(p1, p2);
        segment.move(vec);
        System.out.println(segment);
        segment.rotate(zero, ninetydegrees);
        System.out.println(segment);
        segment.reflect(line);
        System.out.println(segment);


        Point p3 = new Point(-1, 2);
        //Triangle
        //Triangle trianglex = new Triangle(p1,p1,p2); //raises an error
        Triangle triangle = new Triangle(p1, p2, p3);
        System.out.println(triangle);
        triangle.move(vec);
        System.out.println(triangle);
        triangle.reflect(line);
        System.out.println(triangle);
        triangle.rotate(zero, ninetydegrees);
        System.out.println(triangle);

        //Line
        Line line2 = new Line(1,1,0); // y=-x
        System.out.println(Line.arePerpendicular(line, line2));
        System.out.println(Line.areParallel(line, line2));
        System.out.println(Line.intersectionPoint(line, line2));

        //Vector
        Vector vec2 = new Vector(1,1);
        Vector vec3 = Vector.AddVectors(vec, vec2);
        System.out.println("Vector [" + vec3.getDx() + " " + vec3.getDy() + "]");
    }
}
