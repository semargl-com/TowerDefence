package com.semargl.games.towerdefense.view.sprite;

import com.semargl.games.towerdefense.model.Model;
import com.semargl.games.towerdefense.model.base.Coord;
import com.semargl.games.towerdefense.model.base.Direction;
import com.semargl.games.towerdefense.model.monster.MonsterClass;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SpriteStorage {

    public Map<MonsterClass, ImageSeries> walkSprites = new HashMap<>();
    public Map<MonsterClass, Integer> currFrames = new HashMap<>();

    public static SpriteStorage createDemoStorage() throws IOException {
        SpriteStorage spriteStorage = new SpriteStorage();

        ImageSeries wkRoachImageSeries = new ImageSeries();
        BufferedImage image = ImageIO.read(new File("res/tarakan.png"));
        wkRoachImageSeries.images = new BufferedImage[2];
        wkRoachImageSeries.images[0] = scale(image.getSubimage(0, 0, image.getWidth() / 2, image.getHeight()), 0.2, 0.2);
        wkRoachImageSeries.images[1] = scale(image.getSubimage(image.getWidth() / 2, 0, image.getWidth() / 2, image.getHeight()), 0.2, 0.2);
        spriteStorage.walkSprites.put(Model.MONSTER_ZOMBIE, wkRoachImageSeries);
        spriteStorage.currFrames.put(Model.MONSTER_ZOMBIE, 0);

        return spriteStorage;
    }

    public void drawSprite(Graphics g, MonsterClass monsterClass, Coord coord, Direction direction) {
        // create the transform, note that the transformations happen
        // in reversed order (so check them backwards)
        //AffineTransform at = new AffineTransform();

        // 4. translate it to the center of the component
        //at.translate(coord.x, coord.y);

        // 3. do the actual rotation
        //at.rotate(direction.angle);

        // 2. just a scale because this image is big
        //at.scale(0.5, 0.5);

        // 1. translate the object so that you rotate it around the
        //    center (easier :))
        ImageSeries imageSeries = walkSprites.get(monsterClass);
        int currFrameNum = currFrames.get(monsterClass);
        BufferedImage image = imageSeries.images[currFrameNum];
        //at.translate(-image.getWidth()/2, -image.getHeight()/2);

        // draw the image
        //Graphics2D g2d = (Graphics2D) g;
        //g2d.drawImage(image, at, null);

        g.drawImage(image, (int)coord.x, (int)coord.y, null);
    }

    public static BufferedImage scale(BufferedImage before, double sx, double sy) {
        int w = before.getWidth();
        int h = before.getHeight();
        BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(sx, sy);
        AffineTransformOp scaleOp =
                new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        return scaleOp.filter(before, after);
    }

    public void rotateAllFrames() {
        walkSprites.keySet().forEach(this::getNextFrame);
    }

    public int getNextFrame(MonsterClass monsterClass) {
        int curr = currFrames.containsKey(monsterClass) ? currFrames.get(monsterClass) : -1;
        curr++;
        if (curr >= walkSprites.get(monsterClass).images.length) {
            curr = 0;
        }
        currFrames.put(monsterClass, curr);
        return curr;
    }
}
