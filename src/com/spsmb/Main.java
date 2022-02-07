package com.spsmb;

public class Main {

    public static void main(String[] args) {

        Line line = new Line(new Point(1, 4), new Vector(1, 1));

        System.out.println("================= Line =================");
        System.out.printf("Obecna rovnoce: %s\n", line.obecnaRovnice());
        System.out.printf("Parametricke vyjadreni:\n%s\n", line.parametrickeVyjadreni());
        System.out.println();
        System.out.printf("Smernicovy tvar: %s\n", line.smernicovyTvar());
        System.out.printf("Uhel primky: %s\n", line.getAngle());


        System.out.println("----------------------------------------");
        Line line1 = new Line(new Point(1, 1), new Vector(-1, -1));
        Line line2 = new Line(new Point(1, 3), new Vector(2, -1));

        System.out.printf("Line1:                    %s\n", line1.obecnaRovnice());
        System.out.printf("Line2:                    %s\n", line2.obecnaRovnice());
        System.out.println("============= Line x Line1 =============");
        System.out.printf("Are overlapping:          %s\n", line.isOverlapping(line1));
        System.out.printf("Are parallel:             %s\n", line.isParallel(line1));
        System.out.printf("Are intersecting:         %s\n", line.isIntersecting(line1));
        System.out.printf("Intersection Point:       %s\n", line.intersectionPoint(line1));
        System.out.println("============= Line x Line2 =============");
        System.out.printf("Are overlapping:          %s\n", line.isOverlapping(line2));
        System.out.printf("Are parallel:             %s\n", line.isParallel(line2));
        System.out.printf("Are intersecting:         %s\n", line.isIntersecting(line2));
        System.out.printf("Intersection Point:       %s\n", line.intersectionPoint(line2));
        System.out.printf("Angle between:            %s\n", line.angleBetween(line2));


        System.out.println("----------------------------------------");
        Point point = new Point(4, 4);
        Point point1 = new Point(2, 2);

        System.out.printf("point:                    %s\n", point);
        System.out.printf("point1:                   %s\n", point1);
        System.out.println("============= point x point1 ===========");
        System.out.printf("Center point:             %s\n", point.center(point1));
        System.out.printf("Line:                     %s\n", line.obecnaRovnice());
        System.out.printf("Line has point:           %s\n", line.has(point));


        System.out.println("----------------------------------------");
        Vector v = new Vector(1, 1);
        Vector u = new Vector(-1, 3);

        System.out.printf("Vector v:                 %s\n", u);
        System.out.printf("Vector y:                 %s\n", v);
        System.out.println("================= v x u ================");
        System.out.printf("Vector angle:             %s\n", v.getAngle());
        System.out.printf("Angle between:            %s\n", v.angleBetween(u));
    }
}
