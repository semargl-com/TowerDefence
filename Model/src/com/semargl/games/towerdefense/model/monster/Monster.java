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
    public double offsetInPathSegment;

    public Point coord;
    public Direction direction;

    public Monster(MonsterClass monsterClass, MonsterPath monsterPath, int difficultyLevel) {
        this.monsterClass = monsterClass;
        this.monsterPath = monsterPath;
        health = monsterClass.levelHealth.get(difficultyLevel);
        recalculatePosition();
        Log.debug("Created monster: " + toString());
    }

    public void go(long duration) {
        if (monsterState == MonsterState.Normal) {
            double distance = duration * monsterClass.speed / 60_000;
            double leftInSegment = coord.distance(monsterPath.segment.get(pathSegmentNumber + 1));
            if (distance > leftInSegment) {
                pathSegmentNumber++;
                offsetInPathSegment = 0;
            } else {
                offsetInPathSegment += distance;
            }
            recalculatePosition();
        }
    }

    public void hit(int damage) {
        health -= damage;
        if (health < 0)
            health = 0;
        monsterState = MonsterState.Dying;
    }

    private void recalculatePosition() {
        coord = monsterPath.getCoord(pathSegmentNumber, offsetInPathSegment);
        direction = monsterPath.getDirection(pathSegmentNumber);
    }

    @Override
    public String toString() {
        return "{" + monsterClass.name + "/" + monsterState + "/" + health + coord + direction + '}';
    }
}
