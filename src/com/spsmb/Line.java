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
     y = tan(angle) * x + b
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

    // Simplify the equation:       x = -by - c
    public Line simpleLineForm() {
        double a = this.a * (this.a < 0 ? -1 : 1);
        return new Line(a, this.b / this.a, this.c / this.a);
    }


    ////////////////////////////////////////////////////////////////////////////////////////
    // Make vector from line
    ////////////////////////////////////////////////////////////////////////////////////////
    public Vector getVector() {
        return getNormalVector().normal();
    }

    public Vector getNormalVector() {
        return new Vector(a, b);
    }
    ////////////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////
    // Relative line positions
    ////////////////////////////////////////////////////////////////////////////////////////
    public boolean isParallel(Line l) {
        Line p = simpleLineForm();
        Line q = l.simpleLineForm();
        return p.a == q.a && p.b == q.b;
    }

    public boolean isOverlapping(Line l) {
        Line p = simpleLineForm();
        Line q = l.simpleLineForm();
        return p.a == q.a && p.b == q.b && p.c == q.c;
    }

    public boolean has(Point P) {
        return a * P.x + b * P.y + c == 0;
    }

    public Point intersectionPoint(Line l) {
        if (!isIntersecting(l)) {
            return null;
        }
        Line p = simpleLineForm();
        Line q = l.simpleLineForm();

        double y = (p.c + q.c) / (p.b - q.b);
        double x = -p.b * y - p.c;
        return new Point(x, y);
    }

    public boolean isIntersecting(Line l) {
        return !isParallel(l) && !isOverlapping(l);
    }
    ////////////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////
    // Forms of equations
    ////////////////////////////////////////////////////////////////////////////////////////
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
    ////////////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////
    // Angles
    ////////////////////////////////////////////////////////////////////////////////////////
    public Angle angleBetween(Line l) {
        return getVector().angleBetween(l.getVector());
    }

    public Angle getAngle() {
        return getVector().getAngle();
    }
    ////////////////////////////////////////////////////////////////////////////////////////

    public int getDecPoints() {
        return decPoints;
    }

    public void setDecPoints(int decPoints) {
        this.decPoints = Math.max(decPoints, 0);
    }

    @Override
    public String toString() {
        return "Line{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
