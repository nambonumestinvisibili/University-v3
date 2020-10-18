package com.company;

public class Vector {
    public final double dx;
    public final double dy;

    public Vector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public static Vector AddVectors(Vector vec1, Vector vec){
        double newdx = vec1.getDx() + vec.getDx();
        double newdy = vec1.getDy() + vec.getDy();
        return new Vector(newdx, newdy);
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }
}
