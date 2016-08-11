package com.semargl.games.towerdefense.model.monster;

import java.util.List;

public class MonsterClass {

    public List<Integer> levelHealth;
    public MonsterType type;

    public MonsterClass(List<Integer> levelHealth, MonsterType type) {
        this.levelHealth = levelHealth;
        this.type = type;
    }

}
