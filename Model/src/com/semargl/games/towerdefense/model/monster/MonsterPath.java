package com.semargl.games.towerdefense.model.monster;

import com.semargl.games.towerdefense.model.base.Coord;
import com.semargl.games.towerdefense.model.base.Direction;

import java.util.List;

public class MonsterPath {

    public List<Coord> segment;

    public MonsterPath(List<Coord> segment) {
        this.segment = segment;
    }

    public Coord getCoord(int segmentNumber, double offset) {
        Coord coord = segment.get(segmentNumber);
        Direction direction = getDirection(segmentNumber);
        return coord.getOffsetCoord(direction, offset);
    }

    public Direction getDirection(int segmentNumber) {
        return new Direction(segment.get(segmentNumber), segment.get(segmentNumber + 1));
    }
}
