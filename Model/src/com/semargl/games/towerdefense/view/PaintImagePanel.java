package com.semargl.games.towerdefense.view;

import com.semargl.games.towerdefense.Log;
import com.semargl.games.towerdefense.model.Model;
import com.semargl.games.towerdefense.model.monster.Monster;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class PaintImagePanel extends JPanel {

    public static BufferedImage image;
    Model model;

    public PaintImagePanel(Model model) {
        super();

        this.model = model;

        try {
            image = ImageIO.read(new File("res/location0.png"));
        } catch (IOException e) {
            Log.error("Can't load image");
        }
    }

    public void paintComponent(Graphics g)
    {
        g.drawImage(image, 0, 0, null);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Monster monster : model.state.monsters) {
            g.drawOval((int)monster.coord.x, (int)monster.coord.y, 6, 6);
            //Log.debug(monster.toString());
        }
    }

//    public static void main(String [] args)
//    {
//        JFrame f = new JFrame("Window");
//        f.add(new PaintImagePanel());
//        f.setSize(image.getWidth(), image.getHeight() + 30);
//        f.setVisible(true);
//    }
}
