package com.semargl.games.towerdefense.model.monster;

import java.util.List;

public class MonsterClass {

    public List<Integer> levelHealth;
    public MonsterType type;
    public double speed; // pixels per minute
    public String name;

    public MonsterClass(List<Integer> levelHealth, MonsterType type, double speed, String name) {
        this.levelHealth = levelHealth;
        this.type = type;
        this.speed = speed;
        this.name = name;
    }

}
