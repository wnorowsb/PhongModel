package logic;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import static java.lang.Math.*;

public class Draw extends JPanel{
    private Dimension d;
    private ArrayList<Point> points = new ArrayList<Point>();
    private Sphere sphere;

    public Draw(){
        d=new Dimension(500,500);
        this.setMinimumSize(d);
        this.setPreferredSize(d);
        this.setMaximumSize(d);
        this.setMaximumSize(d);
        this.setVisible(true);
        sphere = new Sphere(10000);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        int z;
        int Ox=200;
        int Oy =200;
        int r = 10000;
        Vector c;
        Color color;
        points = sphere.getPoints();
        for (Point point : points) {
            if(point.getL().dotProduct(point.getN()) > 0){
            c = sphere.getKd().multiplyV(point.getLight().getLightColor()).multiplyS(point.getL().dotProduct(point.getN()));
            color = new Color((int) c.getX(), (int) c.getY(), (int) c.getZ());
            //System.out.println(c.getX()+" "+c.getY()+" "+c.getZ());
            }
            else color=new Color(0,0,0);
            g.setColor(color);
            g.drawRect(Ox - point.getX(), Oy - point.getY(), 1, 1);
        }

    }


}
