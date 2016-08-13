package com.semargl.games.towerdefense.model.monster;

import com.semargl.games.towerdefense.Log;
import com.semargl.games.towerdefense.model.base.Direction;
import com.semargl.games.towerdefense.model.base.Point;

public class Monster {

    public MonsterClass monsterClass;
    public MonsterState monsterState = MonsterState.Normal;
    public int health;
    public MonsterPath monsterPath;
    public int pathSegmentNumber;
    public int offsetInPathSegment;

    public Point coord;
    public Direction direction;

    public Monster(MonsterClass monsterClass, MonsterPath monsterPath, int difficultyLevel) { // Point coord, Direction direction) {
        this.monsterClass = monsterClass;
        this.monsterPath = monsterPath;
        health = monsterClass.levelHealth.get(difficultyLevel);
        //this.coord = coord;
        //this.direction = direction;
        Log.debug("Created monster: " + toString());
    }

    public void go(long duration) {
        if (monsterState == MonsterState.Normal) {
            int distance = (int)(duration * monsterClass.speed / 60_000);

        }
    }

    private void recalculatePosition() {

    }

    @Override
    public String toString() {
        return "{" + monsterClass.name + "/" + monsterState + "/" + health + coord + direction + '}';
    }
}
