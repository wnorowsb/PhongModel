package logic;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Draw panel = new Draw();
        JFrame frame = new JFrame("Draw Line");
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setVisible(true);
        frame.setSize(400, 400);
    }
}
