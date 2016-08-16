package com.semargl.games.towerdefense;

import com.semargl.games.towerdefense.controllers.Controller;
import com.semargl.games.towerdefense.model.Location;
import com.semargl.games.towerdefense.model.Model;
import com.semargl.games.towerdefense.model.State;
import com.semargl.games.towerdefense.model.base.Point;
import com.semargl.games.towerdefense.model.monster.MonsterClass;
import com.semargl.games.towerdefense.model.monster.MonsterPath;
import com.semargl.games.towerdefense.model.monster.MonsterType;
import com.semargl.games.towerdefense.model.wave.LevelWaves;
import com.semargl.games.towerdefense.model.wave.WaveClass;
import com.semargl.games.towerdefense.model.weapon.WeaponClass;
import com.semargl.games.towerdefense.model.weapon.WeaponLevel;
import com.semargl.games.towerdefense.test.PointTest;
import com.semargl.games.towerdefense.view.GView;
import com.semargl.games.towerdefense.view.View;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        game();
    }

    public static void game() {
        Model model = Model.createDemoModel();
        View view = new GView(model);
        Controller controller = new Controller(model);

        do {
            model.state.next();
            view.draw();
            if (!controller.sleep(100))
                break;
        } while(!model.state.finished);

    }
}
