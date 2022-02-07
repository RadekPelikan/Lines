package com.spsmb;

public class Point {
    public double x;
    public double y;
    public double z;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        if (z == 0) {
            return String.format("P[%.1f, %.1f]", x, y);
        }
        return String.format("P[%.1f, %.1f, %.1f]", x, y, z);
    }
}
