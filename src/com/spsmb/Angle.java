package com.spsmb;

public class Angle {
    private final double a;

    public Angle(String s) {
        float a;
        if (s.matches("[\\-,+,\\.]?[0-9]\\d*(\\.\\d+)?pi$")) {
            a = Float.parseFloat(s.substring(0, s.length() - 2));
            this.a = a * Math.PI;
            return;
        }
        if (!s.matches("^[\\-,+,\\.]?[0-9]\\d*(\\.\\d+)?$")) {
            this.a = 0;
            return;
        }
        a = Float.parseFloat(s);
        this.a = Math.toRadians(a);
    }

    public Angle(Double a) {
        this.a = Math.toRadians(a);
    }

    public double getRadian() {
        return a;
    }

    public double getDegrees() {
        return Math.toDegrees(a);
    }

    @Override
    public String toString() {
        return "" + getDegrees();
    }
}
