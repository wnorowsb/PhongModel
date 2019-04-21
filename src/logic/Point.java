package logic;
import static java.lang.Math.sqrt;
public class Point {

    private int x,y,z;
    private LightSource light;
    double length;
    private Vector n, v, l, r;

    public LightSource getLight() {
        return light;
    }

    public Vector getN() {
        return n;
    }

    public Vector getV() {
        return v;
    }

    public Vector getL() {
        return l;
    }

    public Vector getR() {
        return r;
    }

    public Point(int x, int y, int z){
        light= new LightSource(200,200,200);
        this.x=x;
        this.y=y;
        this.z=z;
        length=sqrt((x*x) + (y*y) + (z*z));
        this.n = new Vector(x/length, y/length, z/length);

        length=sqrt((x*x) + (y*y) + ((z+400)*(z+400)));
        this.v = new Vector((-1)*x/length, (-1)*y/length, (-1)*(z+400)/length);

        length=sqrt( Math.pow(light.getX() - x, 2) + Math.pow(light.getY() - y, 2) + Math.pow(light.getZ() - z, 2));
        this.l = new Vector((light.getX() - x)/length ,(light.getY() - y)/length ,(light.getZ() - z)/length);

        this.r = n.multiplyS(2*l.dotProduct(n)).minus(l);
        //System.out.println(r.getX());

    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

}
