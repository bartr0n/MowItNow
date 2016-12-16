package fr.mowitnow.brain.actions;

import fr.mowitnow.model.*;


public class TurnLeft implements ActionHandler {

    public void execute(LawnMownerPosition position) {
        position.setOrientation(position.getOrientation().previous());
    }

}
