package logic;
import java.util.ArrayList;
import static java.lang.Math.sqrt;


public class Sphere {
    private int z;
    private ArrayList<Point> points = new ArrayList<Point>();

    public Sphere(int r) {
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
