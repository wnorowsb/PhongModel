package logic;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Draw extends JPanel{
    private Dimension d;
    private ArrayList<Pixel> pixels = new ArrayList<Pixel>();

    public void setPixels(ArrayList<Pixel> pixels) {
        this.pixels = pixels;
    }

    public Draw(){
        d=new Dimension(500,500);
        this.setMinimumSize(d);
        this.setPreferredSize(d);
        this.setMaximumSize(d);
        this.setMaximumSize(d);
        this.setVisible(true);
    }

    public void actualize(){
        this.removeAll();
        this.revalidate();
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);

        int Ox=200;
        int Oy =200;


        for (Pixel pixel : pixels) {
            g.setColor(pixel.getColor());
            g.drawRect(Ox - pixel.getX(), Oy - pixel.getY(), 1, 1);
        }
    }
}
