package com.spsmb;

public class Point {

    public static int id = 0;
    public String name;
    public double x;
    public double y;
    public double z;

    public Point(String name, double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(String name, double x, double y) {
        this(name, x, y, 0);
    }

    public Point(double x, double y) {
        this(String.format("P%d", id++), x, y, 0);
    }

    public Point(double x, double y, double z) {
        this(String.format("P%d", id++), x, y, z);
    }

    public Point center(Point P) {
        return new Point((
                this.x + P.x) / 2,
                (this.y + P.y) / 2);
    }

    public double distance(Point P) {
        return Math.sqrt(Math.pow(P.x - this.x, 2) + Math.pow(P.y - this.y, 2) + Math.pow(P.z - this.z, 2));
    }

    @Override
    public String toString() {
        if (z == 0) {
            return String.format("%s[%.1f, %.1f]",name, x, y);
        }
        return String.format("%s[%.1f, %.1f, %.1f]",name, x, y, z);
    }
}
