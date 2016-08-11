package com.semargl.games.towerdefense.model;

import com.semargl.games.towerdefense.model.base.Point;
import com.semargl.games.towerdefense.model.monster.Monster;
import com.semargl.games.towerdefense.model.wave.Wave;
import com.semargl.games.towerdefense.model.weapon.Weapon;

import java.util.List;
import java.util.Map;

public class State {

    public Location location;
    public int waveNumber;
    public int money;

    public Map<Point, Weapon> weapons;
    public Wave wave;
    public List<Monster> monsters;

}
