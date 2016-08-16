package com.semargl.games.towerdefense.controllers;

import com.semargl.games.towerdefense.Log;
import com.semargl.games.towerdefense.model.Model;

public class Controller {

    Model model;

    public Controller(Model model) {
        this.model = model;
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


}
