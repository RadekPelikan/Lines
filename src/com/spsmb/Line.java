package com.spsmb;

public class Line {

    private int decPoints = 3;

    // ax + by + c = 0
    public double a;
    public double b;
    public double c;

    /*
     Standard form:
     ax + by + c = 0
        a: double
        b: double
        c: double
     */
    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /*
     Slope Intercept Form:
     y = ax + b
        a: double
        b: double
     */
    public Line(double a, double b) {
        this.a = a;
        this.b = 1;
        this.c = b;
    }

    /*
     Angle and height:
     y = atan(angle) * x + b
         angle: Angle
         b: double
     */
    public Line(Angle angle, double b) {
        this.a = Math.tan(angle.getRadian());
        this.b = -1;
        this.c = b;
    }

    /*
     Angle and Point:
     y = tan(angle) * x + P.y
         angle: Angle
         P: Point
     */
    public Line(Angle angle, Point P) {
        this.a = Math.tan(angle.getRadian());
        this.b = -1;
        this.c = -a * P.x - b * P.y;
    }

    /*
     Two points:
     Convert to vector and use Point and vector
         A: Point
         B: Point
     */
    public Line(Point A, Point B) {
        this(A, new Vector(A, B));
    }

    /*
     Parametric equation form:
     x = P.x + v.x * t
     y = P.y + v.y * t
         P: Point
         v: Vector
     */
    public Line(Point P, Vector v) {
        Vector temp = new Vector(v.x, -v.y);
        this.a = temp.y;
        this.b = temp.x;
        P.x *= -temp.y;
        P.y *= -temp.x;
        this.c = P.x + P.y;
    }

    public String parametricForm() {
        int x = 0;
        Point P = new Point(x, (-a * x + c) / b);

        Vector n = new Vector(a, b);
        Vector v = n.normal();
        String s = "x = %." + decPoints + "f %+." + decPoints + "ft\n" +
                "y = %." + decPoints + "f %+." + decPoints + "ft";
        return String.format(s, P.x, v.x, P.y, v.y);
    }

    public String parametrickeVyjadreni() {
        return parametricForm();
    }

    public String standardForm() {
        String s = "%." + decPoints + "fx %+." + decPoints + "fy %+." + decPoints + "f = 0";
        return String.format(s, a, b, c);
    }

    public String obecnaRovnice() {
        return standardForm();
    }

    public String slopeInterceptForm() {
        String s = "y = %." + decPoints + "fx %+." + decPoints + "f";
        return String.format(s, -a / b, -c / b);
    }

    public String smernicovyTvar() {
        return slopeInterceptForm();
    }

    public int getDecPoints() {
        return decPoints;
    }

    public void setDecPoints(int decPoints) {
        this.decPoints = Math.max(decPoints, 0);
    }
}
