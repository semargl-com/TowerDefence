package com.semargl.games.towerdefense.view;

import com.semargl.games.towerdefense.Log;
import com.semargl.games.towerdefense.model.Model;
import com.semargl.games.towerdefense.model.monster.Monster;

public class View {

    protected Model model;

    public View(Model model) {
        this.model = model;
    }

    public void draw() {
        consoleDraw();
    }

    public void consoleDraw() {
        Log.debug("----------------------------------------");
        for (Monster monster : model.state.monsters) {
            Log.debug(monster.toString());
        }
    }
}
