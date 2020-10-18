package com.company;

import java.lang.Math;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void move(Vector vector){
        this.x += vector.getDx();
        this.y += vector.getDy();
    }

    public void rotate(Point p, double angle){
        double u = p.getX()+(this.x-p.getX()) * Math.cos(angle) - (this.y - p.getY()) * Math.sin(angle);
        double v = p.getY()+(this.x-p.getX()) * Math.sin(angle) - (this.y - p.getY()) * Math.cos(angle);
        this.x = u;
        this.y = v;
    }

    public void reflect(Line line){
        double denom = (line.a * line.a + line.b * line.b);
        double u = ((line.b*line.b - line.a * line.a) * this.x - 2 * line.a * line.b *
                this.y - 2 * line.a * line.c)/denom;
        double v = ((line.a * line.a - line.b * line.b) * this.y - 2 * line.a *
                line.b * this.x - 2 * line.b * line.c)/denom;
        this.x = u;
        this.y = v;
    }

    public double distance(Point p){
        double xsDist = Math.pow((p.getX() - this.x), 2.0);
        double ysDist = Math.pow((p.getY() - this.y), 2.0);
        return Math.sqrt(xsDist+ysDist);
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Point){
            return ((Point) obj).getX() == this.x && ((Point) obj).getY() == this.y;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Point of coordinates (" + this.x + ", " + this.y + ")";
    }


    public double getY() {
        return y;
    }

    public double getX(){
        return x;
    }
}
