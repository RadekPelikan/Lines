public class Main {

    public static void main(String[] args) {
        Line p = new Line(2, 2, 1, 5);
        Line q = new Line(2.0, 2.0, 1, 1);
        Line v = new Line(1, 2, 3);

        System.out.println("Parametrické vyjádření přímky: \n" + p.parametricLine());
        System.out.println("Vector X: " + p.directionalVectorX() + ", Vector Y: " + p.directionalVectorY());
        System.out.println("Normal X: " + p.normalVectorX() + ", Normal Y: " + p.normalVectorY());
        System.out.println("Obecné vyjádření přímky: " + p.generalLine());
        System.out.println("Smernicovy tvar primky: " + p.straightLineShape());
        System.out.println("Vzdalenost mezi primkami: " + v.distanceBetweenLines());
    }

}
