package com.company;

import java.util.ArrayList;

public class Triangle extends Figure {
//    ArrayList<Point> points;

    public Triangle(Point p1, Point p2, Point p3){
        super();

        double dist12 = p1.distance(p2);
        double dist13 = p1.distance(p3);
        double dist23 = p2.distance(p3);

        if (dist12 < dist13 + dist23 || dist13 < dist12 + dist23 || dist23 < dist12 + dist13){
            points.add(p1);
            points.add(p2);
            points.add(p3);
        }
        else{
            throw new IllegalArgumentException("points ought not to be collinear");
        }
    }

    @Override
    public String toString(){
        String aux = "[";
        for (Point p : points) {
            aux += p.toString();
            aux += ", ";
        }
        aux += "]";
        return "Triangle of points: " + aux;
    }



}
