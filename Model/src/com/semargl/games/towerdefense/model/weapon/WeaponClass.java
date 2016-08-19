package com.semargl.games.towerdefense.model.weapon;

import com.semargl.games.towerdefense.model.monster.MonsterType;

import java.util.List;
import java.util.Set;

public class WeaponClass {
    public Set<MonsterType> attackMonsterTypes;
    public List<WeaponSpec> weaponSpecs;

    public WeaponClass(Set<MonsterType> attackMonsterTypes, List<WeaponSpec> weaponSpecs) {
        this.attackMonsterTypes = attackMonsterTypes;
        this.weaponSpecs = weaponSpecs;
    }
}
