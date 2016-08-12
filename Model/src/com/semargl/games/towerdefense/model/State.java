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
    public int difficultyLevel;

    public int health;
    public int money;
    public int waveNumber = -1;
    public long lastTime;
    public int monsterNumber = 0;
    public boolean finished = false;

    public Map<Point, Weapon> weapons = new HashMap<>();
    public Wave wave = new Wave();
    public List<Monster> monsters = new LinkedList<>();

    public State(Location location, int difficultyLevel) {
        this.location = location;
        this.difficultyLevel = difficultyLevel;
        health = location.startHealth;
        money = location.startMoney;
    }

    public void next() {
        if (waveNumber == -1) {
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

        checkIsFinished();

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

    private void checkIsFinished() {
        if (waveNumber == location.levelWaves.size() - 1 &&
                monsters.size() == 0 &&
                monsterNumber == location.levelWaves.get(difficultyLevel).waveClasses.get(waveNumber).monsterClasses.size()) {
            finished = true;
        }
    }
}
