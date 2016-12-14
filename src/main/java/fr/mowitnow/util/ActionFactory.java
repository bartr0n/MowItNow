package fr.mowitnow.util;

import fr.mowitnow.model.Action;
import fr.mowitnow.model.actions.*;

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
