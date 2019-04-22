package logic;
import java.util.ArrayList;
import static java.lang.Math.sqrt;


public class Sphere {
    private int z;
    private double n;
    private ArrayList<Point> points = new ArrayList<Point>();
    private Vector kd, ks;

    public Vector getKd() {
        return kd;
    }

    public Vector getKs() {
        return ks;
    }

    public double getN() {
        return n;
    }

    public Sphere(int r) {
        n=100;
        kd= new Vector(0.4, 0.4, 0.4);
        ks= new Vector(0.6, 0.6, 0.6);
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
