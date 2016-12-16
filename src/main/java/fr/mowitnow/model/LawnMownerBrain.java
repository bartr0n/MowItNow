package fr.mowitnow.model;

import fr.mowitnow.brain.actions.ActionHandler;
import fr.mowitnow.util.ActionFactory;
import lombok.Getter;
import lombok.Setter;


public class LawnMownerBrain {

	@Getter
	@Setter
	private LawnMownerPosition currentPosition;

	@Setter
	private Lawn lawn;
	
	

    public void move(Action action) {

        // On calcule la position suivante par rapport � la position actuelle
        LawnMownerPosition newPosition = new LawnMownerPosition(currentPosition);
        ActionHandler actionHandler = ActionFactory.getInstance(action);
        actionHandler.execute(newPosition);

		// On valide si la position est dans les limites de la pelouse. Si c'est
		// le cas, on ne bouge pas
		if (!lawn.isOutOfBoundaries(newPosition.getPosition())) {
			currentPosition = newPosition;
		}

    }

    public LawnMownerPosition getCurrentPosition() {
        return currentPosition;
    }

}
