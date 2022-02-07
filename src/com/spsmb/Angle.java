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
        this.a = a / 180 * Math.PI;
    }

    public Angle(Double a) {
        this.a = a / 180 * Math.PI;
    }

    public double getRadian() {
        return a;
    }

    public double getDegrees() {
        return this.a * 180 / Math.PI;
    }
}
