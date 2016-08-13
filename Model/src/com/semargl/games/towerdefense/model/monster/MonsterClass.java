package com.semargl.games.towerdefense.model.monster;

import java.util.List;

public class MonsterClass {

    public List<Integer> levelHealth;
    public MonsterType type;
    public int speed; // pixels per minute
    public String name;

    public MonsterClass(List<Integer> levelHealth, MonsterType type, int speed, String name) {
        this.levelHealth = levelHealth;
        this.type = type;
        this.speed = speed;
        this.name = name;
    }

}
