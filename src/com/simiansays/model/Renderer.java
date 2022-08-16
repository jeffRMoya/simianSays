package com.simiansays.model;

import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {

    int activated =0;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, WIDTH / 2, HEIGHT / 2);

        g.setColor(Color.RED);
        g.fillRect(WIDTH / 2, 0, WIDTH / 2, HEIGHT / 2);


        g.setColor(Color.ORANGE);
        g.fillRect(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);

        g.setColor(Color.BLUE);
        g.setColor(Color.BLUE.darker());
    }
}