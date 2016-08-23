package com.semargl.games.towerdefense.view;

import com.semargl.games.towerdefense.Log;
import com.semargl.games.towerdefense.model.Model;
import com.semargl.games.towerdefense.model.State;
import com.semargl.games.towerdefense.model.base.Coord;
import com.semargl.games.towerdefense.model.monster.Monster;
import com.semargl.games.towerdefense.model.weapon.Weapon;
import com.semargl.games.towerdefense.model.weapon.WeaponState;

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
            drawMonster(g, monster);
        }

        for (Weapon weapon : state.weapons.values()) {
            drawWeapon(g, weapon);
        }

        g.drawString("Health: " + state.health + ", Money: " + state.money + ", Wave: " + state.waveNumber, 1, 20);
    }

    private void drawMonster(Graphics g, Monster monster) {
        int x = (int)monster.coord.x;
        int y = (int)monster.coord.y;

        g.setColor(Color.BLUE);
        g.drawOval(x - 3, y - 3, 6, 6);

        g.setColor(Color.BLACK);
        g.drawRect(x - 3, y - 8, 12, 5);
        g.setColor(Color.RED);
        int health = monster.health * 10 / monster.monsterClass.levelHealth.get(0);
        g.drawRect(x - 2, y - 7, health, 3);

        g.setColor(Color.BLACK);
    }

    private void drawWeapon(Graphics g, Weapon weapon) {
        int x = (int)weapon.coord.x;
        int y = (int)weapon.coord.y;

        Color color = (weapon.weaponState == WeaponState.Building) ? Color.GRAY : Color.BLACK;
        g.setColor(color);
        g.drawOval(x - 3, y - 3, 6, 6);
        Coord dirCoord = weapon.coord.getOffsetCoord(weapon.direction, 20);
        g.drawLine(x, y, (int)dirCoord.x, (int)dirCoord.y);

        if (weapon.weaponState == WeaponState.Firing) {
            g.setColor(Color.RED);
            Coord fireCoord = weapon.coord.getOffsetCoord(weapon.direction, weapon.spec.distance);
            g.drawLine((int)dirCoord.x, (int)dirCoord.y, (int)fireCoord.x, (int)fireCoord.y);
        }
        else if (weapon.weaponState == WeaponState.Recharging) {
            g.setColor(Color.GREEN);
            int progress = (int)(weapon.progress * 10);
            g.drawLine(x + 10, y + 5, x + 10, y + 5 - progress);
        }
        g.setColor(Color.BLACK);
    }



//    public static void main(String [] args)
//    {
//        JFrame f = new JFrame("Window");
//        f.add(new PaintImagePanel());
//        f.setSize(image.getWidth(), image.getHeight() + 30);
//        f.setVisible(true);
//    }
}
