package com.semargl.games.towerdefense.model;

import com.semargl.games.towerdefense.model.base.Coord;
import com.semargl.games.towerdefense.model.monster.MonsterPath;
import com.semargl.games.towerdefense.model.wave.LevelWaves;
import com.semargl.games.towerdefense.model.weapon.WeaponClass;

import java.util.List;

public class Location {
    public Coord size;
    public int startHealth;
    public int startMoney;
    public List<Coord> fireCoords;
    public List<MonsterPath> monsterPaths;
    public List<LevelWaves> levelWaves;
    public List<WeaponClass> weaponClasses;
}
