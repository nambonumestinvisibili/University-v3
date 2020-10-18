package com.company;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public class LineSegment extends Figure {
//    private ArrayList<Point> points;

    public LineSegment(Point p1, Point p2) {
        super();

        if (p1.equals(p2)){
            throw new IllegalArgumentException("a line should be created with two different points");
        }
        points.add(p1);
        points.add(p2);
    }

    @Override
    public String toString(){
        String p1 = points.get(0).toString();
        String p2 = points.get(1).toString();
        return "Line segment of points: " + p1 + ", " + p2;
    }


}
