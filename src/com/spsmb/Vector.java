package com.spsmb;

public class Vector {

    public static int id = 0;
    public String name;
    public double x;
    public double y;
    public double z;

    public Vector(String name, Point A, Point B) {
        this.name = name;
        this.x = B.x - A.x;
        this.y = B.y - A.y;
        this.z = B.z - A.z;
    }

    public Vector(Point A, Point B) {
        this(String.format("v%d", id++), A, B);
    }

    public Vector(String name, double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(double x, double y) {
        this(String.format("v%d", id++), x, y, 0);
    }

    public Vector(double x, double y, double z) {
        this(String.format("v%d", id++), x, y, z);
    }

    public Vector add(Vector v) {
        return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public double size() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public void scale(float k) {
        this.x *= k;
        this.y *= k;
        this.z *= k;
    }

    public double dotProduct(Vector v) {
        return (this.x * v.x + this.y * v.y + this.z * v.z);
    }

    public Vector crossProduct(Vector v) {
        return new Vector(
                this.y * v.z - this.z * v.y,
                this.z * v.x - this.x * v.z,
                this.x * v.y - this.y * v.x
        );
    }

    public Vector normal() {
        return new Vector(y, -x);
    }

    public Angle angleBetween(Vector v) {
        double i = Math.acos(dotProduct(v) / (this.size() * v.size()));
        return new Angle(Math.toDegrees(i));
    }

    public Angle getAngle() {
        double i = Math.atan(y / x);
        return new Angle(Math.toDegrees(i));
    }

    @Override
    public String toString() {
        if (z == 0) {
            return String.format("%s = (%.1f, %.1f)", name, x, y);
        }
        return String.format("%s = (%.1f, %.1f, %.1f)", name, x, y, z);
    }
}
