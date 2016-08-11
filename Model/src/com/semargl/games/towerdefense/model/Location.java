package com.semargl.games.towerdefense.model;

import com.semargl.games.towerdefense.model.base.Point;
import com.semargl.games.towerdefense.model.monster.MonsterPath;
import com.semargl.games.towerdefense.model.wave.LevelWaves;
import com.semargl.games.towerdefense.model.weapon.WeaponClass;

import java.util.List;

public class Location {
    public Point size;
    public int health;
    public List<Point> firePoints;
    public List<MonsterPath> monsterPaths;
    public List<LevelWaves> levelWaves;
    public List<WeaponClass> weaponClasses;
}
