package com.company;

import java.util.ArrayList;

public abstract class Figure {
    protected ArrayList<Point> points;

    public Figure(){
        points = new ArrayList<>();
    }

    public void move(Vector vector){
        for (Point p : points){
            p.move(vector);
        }
    }

    public void reflect(Line line){
        for (Point p : points){
            p.reflect(line);
        }
    }

    public void rotate(Point p, double angle){
        for (Point point : points){
            point.rotate(p, angle);
        }
    }


}
