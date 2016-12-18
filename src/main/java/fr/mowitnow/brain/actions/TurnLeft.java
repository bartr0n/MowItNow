package fr.mowitnow.brain.actions;

import fr.mowitnow.model.*;


public class TurnLeft implements ActionHandler {

    public void execute(LawnMowerPosition position) {
        position.setOrientation(position.getOrientation().previous());
    }

}
