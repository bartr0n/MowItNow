package fr.mowitnow.util;

import fr.mowitnow.brain.actions.*;
import fr.mowitnow.model.Action;

public class ActionFactory {
	
    public static ActionHandler getInstance(Action action) {

        switch (action) {
            case A:
                return new Forward();
            case D:
                return new TurnRight();
            default:
                return new TurnLeft();
        }

    }
}
