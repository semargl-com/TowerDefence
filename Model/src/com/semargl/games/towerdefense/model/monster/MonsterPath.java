package com.semargl.games.towerdefense.model.monster;

import com.semargl.games.towerdefense.model.base.Point;

import java.util.List;

public class MonsterPath {

    public List<Point> segment; // can get direction because it's lines

    public MonsterPath(List<Point> segment) {
        this.segment = segment;
    }
}
