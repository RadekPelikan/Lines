package com.spsmb;

public class Main {
    public static void main(String[] args) {
        Line line = new Line(new Angle(".25pi"), new Point(-4 , 7));
        System.out.println(line.obecnaRovnice());
        System.out.println(line.parametrickeVyjadreni());
        System.out.println(line.smernicovyTvar());
    }
}
