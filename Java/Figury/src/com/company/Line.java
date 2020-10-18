package com.company;

import com.sun.javaws.exceptions.InvalidArgumentException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Line {
    public final double a;
    public final double b;
    public final double c;

    public Line(double a, double b, double c){
        if (a == 0 && b == 0){
            throw new IllegalArgumentException("A and B values should not be equal to 0 simultanously");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Line move(Line line, Vector v){
        double newc = line.c + v.getDy() - line.a * v.getDx();
        return new Line(line.a, line.b, newc);
    }

    public static boolean areParallel(Line l1, Line l2){
        return l1.a * l2.b == l2.a * l1.b;
    }

    public static boolean arePerpendicular(Line l1, Line l2){
        return l1.a * l2.a == -l1.b * l2.b;
    }

    public static Point intersectionPoint(Line l1, Line l2){
        double W = l1.a * l2.b - l2.a * l1.b;
        double Wx = - l1.c * l2.b + l2.c * l1.b;
        double Wy = l1.c * l2.a - l1.a * l2.c;
        return new Point(Wx/W, Wy/W);
    }




}
