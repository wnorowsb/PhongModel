package logic;

public class Vector {
    private double x,y,z;

    @Override
    public String toString() {
        return  "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public Vector(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector minus (Vector v){
        return new Vector(this.x - v.getX(), this.y - v.getY(), this.z - v.getZ());
    }

    public Vector plus (Vector v){
        return new Vector(this.x + v.getX(), this.y + v.getY(), this.z + v.getZ());
    }

    public Vector multiplyV(Vector v){
        return new Vector(this.x * v.getX(), this.y * v.getY(), this.z * v.getZ());
    }

    public Vector multiplyS(double s){
        return new Vector(this.x * s, this.y * s, this.z * s);
    }


    public double dotProduct(Vector v){
        return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ();
    }


}
