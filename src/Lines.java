public class Lines {

    private int ax;
    private int ay;
    private int bx;
    private int by;

    private double x;
    private double y;
    private int vectorX;
    private int vectorY;

    public Lines(int ax, int ay, int bx, int by) {
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
    }

    public Lines(double x, double y, int vectorX, int vectorY) {
        this.x = x;
        this.y = y;
        this.vectorX = vectorX;
        this.vectorY = vectorY;
    }

    public int directionalVectorX() {
        return ax - bx;
    }

    public int directionalVectorY() {
        return ay - by;
    }

    public String parametricLine() {
        int vectorX = this.vectorX;
        int vectorY = this.vectorY;

        if (vectorX == 0 && vectorY == 0) {
            return "x = " + bx + " + " + directionalVectorX() + "t" + "\n" +
                    "y = " + by + " + " + directionalVectorY() + "t";
        } else {
            return "x = " + x + " + " + vectorX + "t" + "\n" +
                    "y = " + y + " + " + vectorY + "t";
        }
    }

    //(normalVectorX * pointX) + (normalVectorY * pointY) + c = 0

    public int normalVectorX() {
        int normalX = directionalVectorY();
        if (normalX < 0) {
            normalX = normalX + (normalX * (-1)) * 2;
        } else if (normalX > 0) {
            normalX = -normalX;
        }
        return normalX;
    }

    public int normalVectorY() {
        int normalY = directionalVectorX();
        if (normalY < 0) {
            normalY = normalY + (normalY * (-1)) * 2;
        } else if (normalY > 0) {
            normalY = -normalY;
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
        int c = normalVectorX() * ax + normalVectorY() * bx;
        return normalVectorX() + "x" + normalVectorY() + "y" + " + " + -c + " = " + "0";
    }

    //y = kx + q
    //k = tg(vectorY/vectorX)

    public String smerTvar() {
        return "tvar";
    }


    //GETTERS AND SETTERS

    public int getAx() {
        return ax;
    }

    public void setAx(int ax) {
        this.ax = ax;
    }

    public int getAy() {
        return ay;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public int getBx() {
        return bx;
    }

    public void setBx(int bx) {
        this.bx = bx;
    }

    public int getBy() {
        return by;
    }

    public void setBy(int by) {
        this.by = by;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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
