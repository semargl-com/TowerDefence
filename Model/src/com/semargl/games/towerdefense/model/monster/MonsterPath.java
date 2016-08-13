package com.semargl.games.towerdefense.model.monster;

import com.semargl.games.towerdefense.model.base.Direction;
import com.semargl.games.towerdefense.model.base.Point;

import java.util.List;

public class MonsterPath {

    public List<Point> segment; // can get direction because it's lines

    public MonsterPath(List<Point> segment) {
        this.segment = segment;
    }

    public Point getCoord(int segmentNumber, double offset) {
        Point coord = segment.get(segmentNumber);
        Direction direction = getDirection(segmentNumber);
        double angle = direction.angle;
        double coefX = (!direction.isGrowingY()) ? Math.asin(angle) : -Math.asin(angle);
        double coefY = direction.isGrowingX() ? Math.asin(angle - Math.PI / 2) : -Math.asin(angle - Math.PI / 2);
        return new Point(coord.x + (offset * coefX), coord.y + (offset * coefY));
    }

    public Direction getDirection(int segmentNumber) {
        return new Direction(segment.get(segmentNumber), segment.get(segmentNumber + 1));
    }
}
