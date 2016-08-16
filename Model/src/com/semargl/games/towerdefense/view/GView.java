package com.semargl.games.towerdefense.view;

import com.semargl.games.towerdefense.model.Model;

import javax.swing.*;

public class GView extends View {

    //public static BufferedImage bgImage;
    JFrame f;

    public GView(Model model) {
        super(model);
        init();
    }

    private void init() {
//        try {
//            bgImage = ImageIO.read(new File("res/location0.png"));
//        } catch (IOException e) {
//            Log.error("Can't load image");
//        }


        f = new JFrame("Window");
        PaintImagePanel paintImagePanel = new PaintImagePanel(model);
        f.add(paintImagePanel);
        f.setSize(PaintImagePanel.image.getWidth(), PaintImagePanel.image.getHeight() + 30);
        f.setVisible(true);
    }

    @Override
    public void draw() {
        f.repaint();
    }
}
