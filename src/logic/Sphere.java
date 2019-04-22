package logic;
import java.util.ArrayList;
import static java.lang.Math.sqrt;


public class Sphere {
    private int z;
    private double shiness;
    private ArrayList<Point> points = new ArrayList<Point>();
    private Vector kd, ks;

    public Vector getKd() {
        return kd;
    }

    public Vector getKs() {
        return ks;
    }

    public double getShiness() {
        return shiness;
    }

    public void setShiness(double shiness) {
        this.shiness = shiness;
    }

    public void setKd(Vector kd) {
        this.kd = kd;
    }

    public void setKs(Vector ks) {
        this.ks = ks;
    }

    public Sphere(int r) {
        shiness = 100;
        kd= new Vector(0.5, 0.5, 0.5);
        ks= new Vector(0.5, 0.5, 0.5);
        for (int x = -r; x <= r; x++) {
            for (int y = (int) sqrt(r - (x * x)); (-1) * y < (int) sqrt(r - (x * x)); y--) {
                z = (int) sqrt(r - (x * x) - (y * y));
                points.add(new Point(x,y,z));
            }
        }
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}
