package com.semargl.games.towerdefense.model.weapon;

import com.semargl.games.towerdefense.model.monster.MonsterType;

import java.util.List;

public class WeaponClass {
    public List<MonsterType> attackMonsterTypes;
    public List<WeaponLevel> weaponLevels;

    public WeaponClass(List<MonsterType> attackMonsterTypes, List<WeaponLevel> weaponLevels) {
        this.attackMonsterTypes = attackMonsterTypes;
        this.weaponLevels = weaponLevels;
    }
}
