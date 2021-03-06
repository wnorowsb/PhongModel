package logic;

public class LightSource {
    private int x,y,z;
    private Vector lightColor;

    public Vector getLightColor() {
        return lightColor;
    }

    public LightSource(int x, int y, int z){
        this.x=x;
        this.y=y;
        this.z=z;
        lightColor= new Vector(255,255,255);
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

    public void setX(int x) { this.x = x; }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
