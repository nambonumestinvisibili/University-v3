package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Function;


public class TriangleMath {



    public boolean canExist(Point a,
                            Point b,
                            Point c){

        Function<Double, Double> y = x -> (a.y - b.y)/(a.x - b.x) * x + (a.y - ((a.y - b.y)/(a.x - b.x)) * a.x);
        if (isNearlyEqual(c.y, y.apply(c.x))) {
            return false;
        }
        return true;
    }

    public String getTriangleType(Point a,
                                  Point b,
                                  Point c){

        double ab = findSegmentLength(a, b);
        double bc = findSegmentLength(c, b);
        double ac = findSegmentLength(a, c);

        if (isNearlyEqual(ab,bc) && isNearlyEqual(bc, ac) && isNearlyEqual(ab,ac)) return "Rownoboczny";
        else if (!isNearlyEqual(ab, bc) && !isNearlyEqual(bc, ac) && !isNearlyEqual(ab, ac)) return "Roznoboczny";
        else return "Rownoramienny";

    }

    private double findSegmentLength(Point a, Point b){
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y,2));
    }

    private boolean isNearlyEqual(double a, double b){
        return Math.abs(a - b) < 0.001;
    }








}
