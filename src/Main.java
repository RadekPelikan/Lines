public class Main {

    public static void main(String[] args) {
        Lines p = new Lines(2, 2, 1, 5);
        Lines q = new Lines(2.0, 2.0, 1, 1);

        System.out.println("Parametrické vyjádření přímky: \n" + p.parametricLine());
        System.out.println("Vector X: " + p.directionalVectorX() + ", Vector Y: " + p.directionalVectorY());
        System.out.println("Normal X: " + p.normalVectorX() + ", Normal Y: " + p.normalVectorY());
        System.out.println("Obecné vyjádření přímky: " + p.generalLine());
    }

}
