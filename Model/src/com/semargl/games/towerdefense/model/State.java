package com.semargl.games.towerdefense.model;

import com.semargl.games.towerdefense.Log;
import com.semargl.games.towerdefense.model.base.Direction;
import com.semargl.games.towerdefense.model.base.Point;
import com.semargl.games.towerdefense.model.monster.Monster;
import com.semargl.games.towerdefense.model.monster.MonsterClass;
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
    public long currTime;
    public boolean finished = false;

    public Wave wave;
    public Map<Point, Weapon> weapons = new HashMap<>();
    public List<Monster> monsters = new LinkedList<>();

    public State(Location location, int difficultyLevel) {
        this.location = location;
        this.difficultyLevel = difficultyLevel;
        health = location.startHealth;
        money = location.startMoney;
    }

    public void next() {
        currTime = System.currentTimeMillis();
        long duration = lastTime != 0 ? (currTime - lastTime) : 0;

        checkWave();

        for (Point weaponPoint : weapons.keySet()) {
            Weapon weapon = weapons.get(weaponPoint);
        }

        for (Monster monster : monsters) {
            monster.go(duration);
        }

        checkIsFinished();

        lastTime = currTime;
    }

    public boolean sleep(long time) {
        try {
            Thread.sleep(time);
            return true;
        } catch (InterruptedException e) {
            Log.debug("Interrupted");
            return false;
        }
    }

    private void checkWave() {
        if (waveNumber == -1) {
            nextWave();
        }

        if (wave.lastMonsterNumber == -1) {
            pushNextMonster();
        }
        else {
            long lastMonsterPause = wave.waveClass.pauses.get(wave.lastMonsterNumber);
            if (wave.lastMonsterTime + lastMonsterPause < currTime) {
                if (isLastMonsterInWavePushed()) {
                    if (isLastWave()) {
                        finished = true;
                    } else {
                        nextWave();
                    }
                } else {
                    pushNextMonster();
                }
            }
        }
    }

    private void nextWave() {
        waveNumber++;
        Log.debug("nextWave difficultyLevel: " + difficultyLevel + ", waveNumber: " + waveNumber);
        wave = new Wave(location.levelWaves.get(difficultyLevel).waveClasses.get(waveNumber));
    }

    private void pushNextMonster() {
        wave.lastMonsterNumber++;
        MonsterClass monsterClass = wave.waveClass.monsterClasses.get(wave.lastMonsterNumber);
//        Point coord = wave.waveClass.monsterPath.segment.get(0);
//        Point nextSegmentCoord = wave.waveClass.monsterPath.segment.get(1);
//        Direction direction = new Direction(coord, nextSegmentCoord);
        Monster newMonster = new Monster(monsterClass, wave.waveClass.monsterPath, difficultyLevel);
        monsters.add(newMonster);
        wave.lastMonsterTime = currTime;
    }

    private void checkIsFinished() {
        if (isLastWave() && monsters.size() == 0 && isLastMonsterInWavePushed()) {
            finished = true;
        }
    }

    private boolean isLastWave() {
        return waveNumber == location.levelWaves.get(difficultyLevel).waveClasses.size() - 1;
    }

    private boolean isLastMonsterInWavePushed() {
        return wave.lastMonsterNumber == wave.waveClass.monsterClasses.size() - 1;
    }
}
