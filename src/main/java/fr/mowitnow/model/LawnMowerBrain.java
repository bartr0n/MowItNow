package fr.mowitnow.model;

import fr.mowitnow.brain.actions.ActionHandler;
import fr.mowitnow.util.ActionFactory;
import lombok.Getter;
import lombok.Setter;

public class LawnMowerBrain {

	@Getter
	@Setter
	private LawnMowerPosition currentPosition;

	@Setter
	private Lawn lawn;

	public void move(Action action) {

		// On calcule la position suivante par rapport � la position actuelle
		LawnMowerPosition newPosition = new LawnMowerPosition(currentPosition);
		ActionHandler actionHandler = ActionFactory.getInstance(action);
		actionHandler.execute(newPosition);

		// On valide si la position est dans les limites de la pelouse. Si c'est
		// le cas, on ne bouge pas
		if (!lawn.isOutOfBoundaries(newPosition.getPosition())) {
			currentPosition = newPosition;
		}

	}

	public LawnMowerPosition getCurrentPosition() {
		return currentPosition;
	}

}
