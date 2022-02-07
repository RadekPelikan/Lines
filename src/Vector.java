public class Vector {
    public double x;
    public double y;
    public double z;

    public Vector(Point a, Point b) {
        x = b.x - a.x;
        y = b.y - a.y;
        z = b.z - a.z;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector add(Vector v) {
        return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public double size() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)+ Math.pow(this.z, 2));
    }

    public void scale(float k) {
        this.x *= k;
        this.y *= k;
        this.z *= k;
    }

    public double dotProduct(Vector v) {
        return (this.x * v.x + this.y + v.y + this.z + v.z);
    }

    public double angle(Vector v) {
        return Math.acos(dotProduct(v) / (this.size() * v.size()));
    }

    public Vector crossProduct(Vector v) {
        return new Vector(this.y * v.z - this.z * v.y, this.z * v.x - this.x * v.z, this.x * v.y - this.y * v.x);
    }
}
