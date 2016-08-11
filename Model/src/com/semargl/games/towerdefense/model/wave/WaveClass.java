package com.semargl.games.towerdefense.model.wave;

import com.semargl.games.towerdefense.model.monster.MonsterClass;

import java.util.List;

public class WaveClass {

    public int pathNumber;
    public List<MonsterClass> monsterClasses;
    public List<Long> pauses;

    public WaveClass(int pathNumber, List<MonsterClass> monsterClasses, List<Long> pauses) {
        this.pathNumber = pathNumber;
        this.monsterClasses = monsterClasses;
        this.pauses = pauses;
    }
}
