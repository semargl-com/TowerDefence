package com.semargl.games.towerdefense.model.weapon;

import com.semargl.games.towerdefense.model.monster.Monster;
import com.semargl.games.towerdefense.model.base.Direction;

public class Weapon {

    public WeaponClass weaponClass;
    public int level;
    public WeaponState weaponState;
    public Direction direction;
    public Monster targetMonster;
    public long firedTime;

}
