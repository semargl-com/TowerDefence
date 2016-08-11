package com.semargl.games.towerdefense.model;

import com.semargl.games.towerdefense.model.base.Point;
import com.semargl.games.towerdefense.model.monster.Monster;
import com.semargl.games.towerdefense.model.wave.Wave;
import com.semargl.games.towerdefense.model.weapon.Weapon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class State {

    public Location location;

    public int health;
    public int money;
    public int waveNumber = 0;
    public long lastTime;

    public Map<Point, Weapon> weapons = new HashMap<>();
    public Wave wave = new Wave();
    public List<Monster> monsters = new LinkedList<>();

    public State(Location location) {
        this.location = location;
        health = location.startHealth;
        money = location.startMoney;
    }

    public void next() {
        if (waveNumber == 0) {
            lastTime = System.currentTimeMillis();
            waveNumber++;
            return;
        }

        long currTime = System.currentTimeMillis();
        long duration = currTime - lastTime;

        for (Point weaponPoint : weapons.keySet()) {
            Weapon weapon = weapons.get(weaponPoint);

        }

        for (Monster monster : monsters) {

        }

        lastTime = currTime;
    }

    public boolean sleep(long time) {
        try {
            Thread.sleep(time);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
}
