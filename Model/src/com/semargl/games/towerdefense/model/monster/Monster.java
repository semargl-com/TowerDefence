package com.semargl.games.towerdefense.model.monster;

import com.semargl.games.towerdefense.Log;
import com.semargl.games.towerdefense.model.base.Direction;
import com.semargl.games.towerdefense.model.base.Point;

public class Monster {

    public MonsterClass monsterClass;
    public MonsterState monsterState = MonsterState.Normal;
    public int health;
    public Point coord;
    public Direction direction;

    public Monster(MonsterClass monsterClass, int difficultyLevel, Point coord, Direction direction) {
        this.monsterClass = monsterClass;
        health = monsterClass.levelHealth.get(difficultyLevel);
        this.coord = coord;
        this.direction = direction;
        Log.debug("Created monster: " + toString());
    }

    public void go(long duration) {

    }

    @Override
    public String toString() {
        return "{" + monsterClass.name + "/" + monsterState + "/" + health + coord + direction + '}';
    }
}
