package com.semargl.games.towerdefense.model.monster;

import java.util.List;

public class MonsterClass {

    public List<Integer> levelHealth;
    public MonsterType type;
    public String name;

    public MonsterClass(List<Integer> levelHealth, MonsterType type, String name) {
        this.levelHealth = levelHealth;
        this.type = type;
        this.name = name;
    }

}
