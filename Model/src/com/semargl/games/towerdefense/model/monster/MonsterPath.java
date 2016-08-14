package com.semargl.games.towerdefense.model.monster;

import com.semargl.games.towerdefense.model.base.Direction;
import com.semargl.games.towerdefense.model.base.Point;

import java.util.List;

public class MonsterPath {

    public List<Point> segment;

    public MonsterPath(List<Point> segment) {
        this.segment = segment;
    }

    public Point getCoord(int segmentNumber, double offset) {
        Point coord = segment.get(segmentNumber);
        Direction direction = getDirection(segmentNumber);
        return coord.getOffsetCoord(direction, offset);
    }

    public Direction getDirection(int segmentNumber) {
        return new Direction(segment.get(segmentNumber), segment.get(segmentNumber + 1));
    }
}
