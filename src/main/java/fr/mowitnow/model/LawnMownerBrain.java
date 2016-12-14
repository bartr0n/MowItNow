package fr.mowitnow.model;

import fr.mowitnow.model.actions.ActionHandler;
import fr.mowitnow.util.ActionFactory;

public class LawnMownerBrain {

    private LawnMownerPosition currentPosition;


    public void move(Action action) {

        // On calcule la position suivante par rapport � la position actuelle
        LawnMownerPosition newPosition = new LawnMownerPosition(currentPosition);
        ActionHandler actionHandler = ActionFactory.getInstance(action);
        actionHandler.execute(newPosition);

        // On valide si la position est dans les limites de la pelouse. Si c'est
        // le cas, on ne bouge pas

    }

    public LawnMownerPosition getCurrentPosition() {
        return currentPosition;
    }

}
