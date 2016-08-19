package com.semargl.games.towerdefense;

import com.semargl.games.towerdefense.controllers.Controller;
import com.semargl.games.towerdefense.model.Model;
import com.semargl.games.towerdefense.view.GView;
import com.semargl.games.towerdefense.view.View;

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
