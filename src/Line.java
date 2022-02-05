public class Line {

    private int pointAx;
    private int pointAy;
    private int pointBx;
    private int pointBy;

    private double pointX;
    private double pointY;
    private int vectorX;
    private int vectorY;

    private int q;
    private int k;
    private int ys;
    private int xs;
    private int xt;

    private double vectorAx;
    private double vectorAy;
    private double c;

    Hub hub;

    public Line(Hub hub) {
        this.hub = hub;
    }

    public Line(int ax, int ay, int bx, int by) {
        this.pointAx = ax;
        this.pointAy = ay;
        this.pointBx = bx;
        this.pointBy = by;

        vectorX = directionalVectorX();
        vectorY = directionalVectorY();
    }

    public Line(double x, double y, int vectorX, int vectorY) {
        this.pointX = x;
        this.pointY = y;
        this.vectorX = vectorX;
        this.vectorY = vectorY;
    }

    // x + y + c = 0
    public Line(int a, int b, int c) {
        this.vectorAx = a;
        this.vectorAy = b;
        this.c = c;
    }

    public int directionalVectorX() {
        return pointAx - pointBx;
    }

    public int directionalVectorY() {
        return pointAy - pointBy;
    }

    public String parametricLine() {
        int x = pointBx + vectorX;
        return "x = " + pointBx + " + " + vectorX + "t" + "\n" +
                "y = " + pointBy + " + " + vectorY + "t";
    }

    //(normalVectorX * pointX) + (normalVectorY * pointY) + c = 0

    public int normalVectorX() {
        int normalX = vectorY;
        if (normalX < 0 || vectorX < 0 && normalX > 0 || vectorX > 0) {
            normalX = normalX + (normalX * (-1)) * 2;
        }
        return normalX;
    }

    public int normalVectorY() {
        int normalY = vectorX;
        if (normalY < 0 && vectorY < 0 || normalY > 0 && vectorY > 0) {
            normalY = normalY + (normalY * (-1)) * 2;
        }
        return normalY;
    }

    public int normalVector() {
        int normalX = directionalVectorY();
        int normalY = directionalVectorX();

        if (normalX < 0 && normalY < 0) {
            normalX += -normalX * 2;
        } else {
            if (normalX < 0) {
                normalX += normalX * 2;
            } else if (normalY < 0) {
                normalY += -normalY * 2;
            }
        }

        if (normalX > 0 && normalY > 0) {
            normalX = normalX + (normalX * (-1)) * 2;
        } else {
            if (normalY > 0) {
                normalY = -normalY;
            } else if (normalX > 0) {
                normalX = -normalX;
            }
        }


        return normalX;
    }


    public String generalLine() {
        return normalVectorX() + "x + " + normalVectorY() + "y" + " + " + calculateC(Main.p) + " = " + "0";
    }

    public int calculateC(Line line) {
        return (normalVectorX() * pointAx + normalVectorY() * pointAy) * -1;
    }


    public String straightLineShape() {
        //y = kx + q
        //k = tg(vectorY/vectorX)

        ys = pointAy - pointBy;
        xs = pointAx - pointBx;
        k = ys / xs;

        xt = pointAx * (k);
        if (xt < 0) {
            q = pointAy - xt;
        } else {
            q = pointAy + xt;
        }


        return "k = " + k + ", q = " + q + ", y = " + k + "x" + " + " + q;
    }

    //v = ax0 + by0 + c / √ a2 + b2
    /*public String distanceBetweenLines() {

    Fuuuuj, Radku.

        double distance = (vectorAx * 0 + vectorAy * 0 + c) / Math.sqrt(vectorAx * vectorAx + vectorAy * vectorAy);

        if (distance < 0) {
            distance *= -1;
        }

        return "v = " + distance;
    }
     */

    public int chosenX, chosenY;

    public void checkPoint(int pointAX, int pointAY, Line line) {
        if (line.normalVectorX() * pointAX + line.normalVectorY() * pointAY + calculateC(Main.p) == 0) {
            System.out.println("Bod leží na přímce");
            chosenX = pointAX;
            chosenY = pointAY;
            if (calculateDistance(Main.z) == 0) {
                System.out.println("Přímky jsou totožné");
            }
            System.out.println("Distance: " + calculateDistance(Main.z));

        } else {
            System.out.println("Bod neleží na přímce");
        }
    }

    public int sourX, sourY;

    public int calculateLineRelation(Line line1, Line line2, int pointCoord) {
        int y = (pointCoord * normalVectorX() + calculateC(line1)) * -1;
        sourY = y * normalVectorY();
        sourX = pointCoord;
        return y * normalVectorY();
    }

    //v = ax0 + by0 + c / √ a2 + b2
    public double calculateDistance(Line line) {
        double v = ((line.normalVectorX() * chosenX) + (line.normalVectorY() * chosenY + calculateC(Main.z))) / Math.sqrt((line.normalVectorX() * line.normalVectorX()) + (line.normalVectorY() * line.normalVectorY()));
        return v;
    }

    //GETTERS AND SETTERS

    public int getPointAx() {
        return pointAx;
    }

    public void setPointAx(int pointAx) {
        this.pointAx = pointAx;
    }

    public int getPointAy() {
        return pointAy;
    }

    public void setPointAy(int pointAy) {
        this.pointAy = pointAy;
    }

    public int getPointBx() {
        return pointBx;
    }

    public void setPointBx(int pointBx) {
        this.pointBx = pointBx;
    }

    public int getPointBy() {
        return pointBy;
    }

    public void setPointBy(int pointBy) {
        this.pointBy = pointBy;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public int getVectorX() {
        return vectorX;
    }

    public void setVectorX(int vectorX) {
        this.vectorX = vectorX;
    }

    public int getVectorY() {
        return vectorY;
    }

    public void setVectorY(int vectorY) {
        this.vectorY = vectorY;
    }
}
