package com.semargl.games.towerdefense.model;

import com.semargl.games.towerdefense.model.base.Point;
import com.semargl.games.towerdefense.model.monster.MonsterClass;
import com.semargl.games.towerdefense.model.monster.MonsterPath;
import com.semargl.games.towerdefense.model.monster.MonsterType;
import com.semargl.games.towerdefense.model.wave.LevelWaves;
import com.semargl.games.towerdefense.model.wave.WaveClass;
import com.semargl.games.towerdefense.model.weapon.WeaponClass;
import com.semargl.games.towerdefense.model.weapon.WeaponLevel;

import java.util.Arrays;

public class Model {

    public State state;

    public static Model createDemoModel() {
        Location location = initLocation();
        Model model = new Model();
        model.state = new State(location, 0);
        return model;
    }

    public static Location initLocation() {
        Location location = new Location();
        location.size = new Point(500, 500);
        location.startHealth = 200;
        location.firePoints = Arrays.asList(
                new Point(56, 103), new Point(172, 103), new Point(382, 103),
                new Point(264, 207), new Point(200, 260), new Point(164, 332),
                new Point(266, 394), new Point(412, 326));
        location.monsterPaths = Arrays.asList(new MonsterPath(Arrays.asList(
                new Point(0, 33), new Point(237, 33), new Point(279, 75),
                new Point(277, 118), new Point(92, 332), new Point(92, 380),
                new Point(959, 467), new Point(368, 395), new Point(300, 300),
                new Point(400, 170), new Point(499, 170))),
                null);
        location.levelWaves = Arrays.asList(new LevelWaves(Arrays.asList(
                new WaveClass(location.monsterPaths.get(0),
                        Arrays.asList(MONSTER_ZOMBIE, MONSTER_ZOMBIE, MONSTER_ZOMBIE),
                        Arrays.asList(3000L, 3000L, 5000L)),
                new WaveClass(location.monsterPaths.get(0),
                        Arrays.asList(MONSTER_ZOMBIE, MONSTER_ZOMBIE, MONSTER_ZOMBIE, MONSTER_ZOMBIE, MONSTER_ZOMBIE),
                        Arrays.asList(1000L, 1000L, 2000L, 1000L, 5000L))
        )), null);
        location.weaponClasses = Arrays.asList(WEAPON_MACHINEGUN, null);
        return location;
    }

    public static MonsterClass MONSTER_ZOMBIE = new MonsterClass(
            Arrays.asList(50, 60, 75, 85, 100),
            MonsterType.Land,
            1000,
            "Zombie");

    public static WeaponClass WEAPON_MACHINEGUN = new WeaponClass(
            Arrays.asList(MonsterType.Land, MonsterType.Flying),
            Arrays.asList(
                    new WeaponLevel(200, 3, 150, 150, 0),
                    new WeaponLevel(40, 3, 200, 175, 0),
                    new WeaponLevel(45, 3, 200, 200, 0),
                    new WeaponLevel(50, 4, 200, 200, 0),
                    new WeaponLevel(55, 4, 250, 225, 0)
            ));
}