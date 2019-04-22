package logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;

public class Phong implements KeyListener {
    private Draw panel;
    private LightSource light;
    private Sphere sphere;
    private Vector v,n,r,l,diff, spec, c;
    private int x,y,z;
    private double length;
    private Color color;
    private ArrayList<Point> points = new ArrayList<Point>();
    private ArrayList<Pixel> pixels = new ArrayList<Pixel>();
    private Pixel pixel;
    public Phong(){
        sphere=new Sphere (10000);
        light= new LightSource(0,0,400);
        this.panel = new Draw();

        generate();
        JFrame frame = new JFrame("Phong Model");
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.addKeyListener(this);
        frame.setVisible(true);
        frame.setSize(400, 400);
    }

    public void generate(){
        points = sphere.getPoints();
        for (Point point : points) {
            pixel = calculatePixel(point);
            pixels.add(pixel);
        }
        panel.setPixels(pixels);
    }


    public Pixel calculatePixel(Point p){
        x = p.getX();
        y = p.getY();
        z = p.getZ();
        length = sqrt((x*x) + (y*y) + (z*z));
        this.n = new Vector(x/length, y/length, z/length);

        length=sqrt((x*x) + (y*y) + ((z+100)*(z+100)));
        this.v = new Vector(x/length, y/length, (z+100)/length);

        length=sqrt( Math.pow(light.getX() - x, 2) + Math.pow(light.getY() - y, 2) + Math.pow(light.getZ() - z, 2));
        this.l = new Vector((light.getX() - x)/length ,(light.getY() - y)/length ,(light.getZ() - z)/length);

        this.r = n.multiplyS(2*l.dotProduct(n)).minus(l);

        if(l.dotProduct(n) > 0){
            diff = sphere.getKd().multiplyV(light.getLightColor()).multiplyS(l.dotProduct(n));
            spec = sphere.getKs().multiplyV(light.getLightColor()).multiplyS(Math.pow(max(0.0, r.dotProduct(v)),sphere.getN()));
            c = diff.plus(spec);
            color = new Color((int) c.getX(), (int) c.getY(), (int) c.getZ());
        }
        else color=new Color(0,0,0);

        return new Pixel(x,y,color);
    }

    public void moveRight(){
        light.setX(light.getX()-50);
        generate();
        panel.actualize();
    }

    public void moveLeft(){
        light.setX(light.getX()+50);
        generate();
        panel.actualize();
    }

    public void moveUp(){
        light.setY(light.getY()+50);
        generate();
        panel.actualize();
    }

    public void moveDown(){
        light.setY(light.getY()-50);
        generate();
        panel.actualize();
    }

    public void moveForward(){
        light.setZ(light.getZ()+50);
        generate();
        panel.actualize();
    }

    public void moveBackward(){
        light.setZ(light.getZ()-50);
        generate();
        panel.actualize();
    }

    public void keyPressed (KeyEvent e){
        if (e.getKeyChar() == 'q' || e.getKeyChar() == 'Q')
            this.moveForward();
        if (e.getKeyChar() == 'e' || e.getKeyChar() == 'E')
            this.moveBackward();
        if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A')
            this.moveLeft();
        if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D')
            this.moveRight();
        if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W')
            this.moveUp();
        if (e.getKeyChar() == 's' || e.getKeyChar() == 'S')
            this.moveDown();
    }

    public void keyTyped(KeyEvent e) { }

    public void keyReleased(KeyEvent e) { }
}
