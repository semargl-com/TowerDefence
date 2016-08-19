package com.semargl.games.towerdefense.view;

import com.semargl.games.towerdefense.Log;
import com.semargl.games.towerdefense.model.Model;
import com.semargl.games.towerdefense.model.State;
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

        State state = model.state;

        for (Monster monster : state.monsters) {
            g.setColor(Color.BLUE);
            g.drawOval((int)monster.coord.x, (int)monster.coord.y, 6, 6);
            g.setColor(Color.BLACK);
            g.drawRect((int)monster.coord.x - 3, (int)monster.coord.y - 8, 12, 5);
            g.setColor(Color.RED);
            int health = monster.health * 10 / monster.monsterClass.levelHealth.get(0);
            g.drawRect((int)monster.coord.x - 2, (int)monster.coord.y - 7, health, 3);
        }

        g.drawString("Health: " + state.health + ", Money: " + state.money + ", Wave: " + state.waveNumber, 1, 20);
    }

//    public static void main(String [] args)
//    {
//        JFrame f = new JFrame("Window");
//        f.add(new PaintImagePanel());
//        f.setSize(image.getWidth(), image.getHeight() + 30);
//        f.setVisible(true);
//    }
}
