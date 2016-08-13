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
        return coord; ////////
//        Point nextSegmentCoord = wave.waveClass.monsterPath.segment.get(1);
//        Direction direction = new Direction(coord, nextSegmentCoord);

    }

    public Direction getDirection(int segmentNumber) {
        return new Direction(segment.get(segmentNumber), segment.get(segmentNumber + 1));
    }
}
